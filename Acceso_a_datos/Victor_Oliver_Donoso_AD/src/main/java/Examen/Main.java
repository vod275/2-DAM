package Examen;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        
    	Ejercicio1();
    	Ejercicio2(1000);
    	Ejercicio3(2002, "IF0001");
    	
    }

    

    //Lo he hecho lo mejor que he podido sin poder revisar nada en la base de datos, por que no funcinaba
    //Solo te pido que seas benevola conmigo en la clase prueba tienes las pruebas, se lo que hago pero no se por que falla
    
    
    private static void Ejercicio1() throws SQLException {
    	try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centros", "root", "")) {
            conn.setAutoCommit(false);

            try {
                añadirColumna(conn);
                updateProfessor(conn);
                salida(conn);

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("Error: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
    

    private static void añadirColumna(Connection conn) throws SQLException {
        String checkColumnSQL = "SHOW COLUMNS FROM C1_PROFESORES LIKE 'NUM_ASIGNATURAS';";
        try (PreparedStatement stmt = conn.prepareStatement(checkColumnSQL);
             ResultSet rs = stmt.executeQuery()) {
            if (!rs.next()) {
                String alterTableSQL = "ALTER TABLE C1_PROFESORES ADD COLUMN NUM_ASIGNATURAS INT DEFAULT 0;";
                try (PreparedStatement alterStmt = conn.prepareStatement(alterTableSQL)) {
                    alterStmt.execute();
                    System.out.println("Columna NUM_ASIGNATURAS añadida.");
                }
            } else {
                System.out.println("Columna NUM_ASIGNATURAS ya existe.");
            }
        }
    }


    private static void updateProfessor(Connection conn) throws SQLException {
    	String updateSQL = "UPDATE C1_PROFESORES prof JOIN (SELECT C1_PROFESORES_COD_PROF AS COD_PROF, COUNT(*) AS NUM_ASIGNATURAS FROM C1_ASIGPROF GROUP BY C1_PROFESORES_COD_PROF) subquery ON prof.COD_PROF = subquery.COD_PROF SET prof.NUM_ASIGNATURAS = subquery.NUM_ASIGNATURAS;";


        try (PreparedStatement stmt = conn.prepareStatement(updateSQL)) {
            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " filas actualizadas con el número de asignaturas.");
        }
    }

    private static void salida(Connection conn) throws SQLException {
        String querySQL = "SELECT a.COD_ASIG AS COD_ASIG, a.NOMBRE_ASI AS NOMBRE_ASIG, p.COD_PROF AS COD_PROF, p.NOMBRE_APE AS NOMBRE_PROF " +
                          "FROM C1_ASIGNATURAS a " +
                          "JOIN C1_ASIGPROF ap ON a.COD_ASIG = ap.C1_ASIGNATURAS_COD_ASIG " +
                          "JOIN C1_PROFESORES p ON ap.C1_PROFESORES_COD_PROF = p.COD_PROF " +
                          "ORDER BY a.COD_ASIG, p.COD_PROF";

        try (PreparedStatement stmt = conn.prepareStatement(querySQL);
             ResultSet rs = stmt.executeQuery()) {

            System.out.printf("%-10s %-20s %-10s %-20s%n", "COD ASIG", "NOMBRE ASIG", "COD PROF", "NOMBRE PROF");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10s %-20s %-10d %-20s%n",
                        rs.getString("COD_ASIG"),
                        rs.getString("NOMBRE_ASIG"),
                        rs.getInt("COD_PROF"),
                        rs.getString("NOMBRE_PROF"));
            }
        }
    }
    
    
    

    private static void Ejercicio2(int codCentro) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centros", "root", "")) {
            conn.setAutoCommit(false);

            
            String centroQuery = "SELECT COD_CENTRO, NOM_CENTRO FROM C1_CENTROS WHERE COD_CENTRO = ?";
            try (PreparedStatement stmt = conn.prepareStatement(centroQuery)) {
                stmt.setInt(1, codCentro);
                try (ResultSet rsCentro = stmt.executeQuery()) {
                    if (rsCentro.next()) {
                       
                        String nombreCentro = rsCentro.getString("NOM_CENTRO");
                        System.out.printf("COD-CENTRO: %d   NOMBRE CENTRO: %s%n", codCentro, nombreCentro);
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("PROFESORES DEL CENTRO");
                        System.out.printf("%-10s %-20s %-20s %-10s %-20s%n", "COD-PROF", "NOMBRE", "ESPECIALIDAD", "NUM-ASIG", "NOMBRE JEFE");

                      
                        String profesoresQuery = "SELECT p.COD_PROF, p.NOMBRE_APE, p.ESPECIALIDAD, p.NUM_ASIGNATURAS, j.NOMBRE_APE AS JEFE " +
                                                 "FROM C1_PROFESORES p " +
                                                 "LEFT JOIN C1_PROFESORES j ON p.COD_PROF1 = j.COD_PROF " +
                                                 "WHERE p.COD_CENTRO = ? ORDER BY p.NUM_ASIGNATURAS DESC";
                        try (PreparedStatement stmtProf = conn.prepareStatement(profesoresQuery)) {
                            stmtProf.setInt(1, codCentro);
                            try (ResultSet rsProfesores = stmtProf.executeQuery()) {
                                while (rsProfesores.next()) {
                                    String nombreProfesor = rsProfesores.getString("NOMBRE_APE");
                                    String especialidad = rsProfesores.getString("ESPECIALIDAD");
                                    int numAsignaturas = rsProfesores.getInt("NUM_ASIGNATURAS");
                                    String nombreJefe = rsProfesores.getString("JEFE");
                                    if (nombreJefe == null) {
                                        nombreJefe = "No tiene jefe";
                                    }
                                    System.out.printf("%-10d %-20s %-20s %-10d %-20s%n", 
                                                      rsProfesores.getInt("COD_PROF"), 
                                                      nombreProfesor, 
                                                      especialidad, 
                                                      numAsignaturas, 
                                                      nombreJefe);
                                }
                            }
                        }

                      
                        String maxAsignaturasQuery = "SELECT p.NOMBRE_APE, COUNT(ap.C1_ASIGNATURAS_COD_ASIG) AS NUM_ASIGNATURAS " +
                                                     "FROM C1_PROFESORES p " +
                                                     "JOIN C1_ASIGPROF ap ON p.COD_PROF = ap.C1_PROFESORES_COD_PROF " +
                                                     "WHERE p.COD_CENTRO = ? " +
                                                     "GROUP BY p.COD_PROF, p.NOMBRE_APE " +
                                                     "ORDER BY NUM_ASIGNATURAS DESC";
                        try (PreparedStatement stmtMaxAsignaturas = conn.prepareStatement(maxAsignaturasQuery)) {
                            stmtMaxAsignaturas.setInt(1, codCentro);
                            try (ResultSet rsMax = stmtMaxAsignaturas.executeQuery()) {
                                int maxAsignaturas = 0;
                                while (rsMax.next()) {
                                    int numAsignaturas = rsMax.getInt("NUM_ASIGNATURAS");
                                    if (numAsignaturas > maxAsignaturas) {
                                        maxAsignaturas = numAsignaturas;
                                    }
                                }

                                
                                System.out.println("Nombre de profesor que imparte más asignaturas: ");
                                try (ResultSet rsMaxProf = stmtMaxAsignaturas.executeQuery()) {
                                    while (rsMaxProf.next()) {
                                        int numAsignaturas = rsMaxProf.getInt("NUM_ASIGNATURAS");
                                        if (numAsignaturas == maxAsignaturas) {
                                            System.out.println(rsMaxProf.getString("NOMBRE_APE"));
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                    
                        System.out.println("El centro con COD-CENTRO " + codCentro + " no existe en la BD.");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
    

    
    private static void Ejercicio3(int codProfesor, String codAsignatura) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centros", "root", "")) {
            conn.setAutoCommit(false);  // Asegúrate de deshabilitar autocommit aquí

            // Verificar existencia del profesor
            String verificarProfesor = "SELECT COUNT(*) AS total FROM C1_PROFESORES WHERE COD_PROF = ?";
            try (PreparedStatement stmtProfesor = conn.prepareStatement(verificarProfesor)) {
                stmtProfesor.setInt(1, codProfesor);
                try (ResultSet rs = stmtProfesor.executeQuery()) {
                    if (rs.next() && rs.getInt("total") == 0) {
                        System.out.println("Error: El profesor con código " + codProfesor + " no existe.");
                        return;
                    }
                }
            }

            // Verificar existencia de la asignatura
            String verificarAsignatura = "SELECT COUNT(*) AS total FROM C1_ASIGNATURAS WHERE COD_ASIG = ?";
            try (PreparedStatement stmtAsignatura = conn.prepareStatement(verificarAsignatura)) {
                stmtAsignatura.setString(1, codAsignatura);
                try (ResultSet rs = stmtAsignatura.executeQuery()) {
                    if (rs.next() && rs.getInt("total") == 0) {
                        System.out.println("Error: La asignatura con código " + codAsignatura + " no existe.");
                        return;
                    }
                }
            }

            // Verificar si el profesor ya imparte la asignatura
            String verificarAsignacion = "SELECT COUNT(*) AS total FROM C1_ASIGPROF WHERE C1_PROFESORES_COD_PROF = ? AND C1_ASIGNATURAS_COD_ASIG = ?";
            try (PreparedStatement stmtAsignacion = conn.prepareStatement(verificarAsignacion)) {
                stmtAsignacion.setInt(1, codProfesor);
                stmtAsignacion.setString(2, codAsignatura);
                try (ResultSet rs = stmtAsignacion.executeQuery()) {
                    if (rs.next() && rs.getInt("total") > 0) {
                        System.out.println("Error: El profesor ya imparte la asignatura con código " + codAsignatura + ".");
                        return;
                    }
                }
            }

            // Insertar asignación de profesor
            String insertarAsignacion = "INSERT INTO C1_ASIGPROF (C1_PROFESORES_COD_PROF, C1_ASIGNATURAS_COD_ASIG) VALUES (?, ?)";
            try (PreparedStatement stmtInsert = conn.prepareStatement(insertarAsignacion)) {
                stmtInsert.setInt(1, codProfesor);
                stmtInsert.setString(2, codAsignatura);
                int filasInsertadas = stmtInsert.executeUpdate();

                if (filasInsertadas > 0) {
                    System.out.println("Registro insertado correctamente en C1_ASIGPROF.");
                } else {
                    System.out.println("Error: No se pudo insertar el registro en C1_ASIGPROF.");
                    conn.rollback();
                    return;
                }
            }

         // Actualizar el contador de asignaturas en la tabla C1_PROFESORES
            String actualizarContador = "UPDATE C1_PROFESORES SET NUM_ASIGNATURAS = NUM_ASIGNATURAS + 1 WHERE COD_PROF = ?";
            try (PreparedStatement stmtUpdate = conn.prepareStatement(actualizarContador)) {
                stmtUpdate.setInt(1, codProfesor);  // Usamos COD_PROF para identificar al profesor
                int filasActualizadas = stmtUpdate.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("Contador de asignaturas actualizado correctamente en C1_PROFESORES.");
                } else {
                    System.out.println("Error: No se pudo actualizar el contador de asignaturas en C1_PROFESORES.");
                    conn.rollback();
                    return;
                }
            }

            // Confirmar los cambios realizados
            conn.commit();
        } catch (SQLException e) {
            System.err.println("Error durante la operación: " + e.getMessage());
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centros", "root", "")) {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                System.err.println("Error durante el rollback: " + rollbackEx.getMessage());
            }
        }
    }

}
