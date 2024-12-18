package hybernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import hibernateClases2.Camisetas;
import hibernateClases2.Ciclistas;
import hibernateClases2.Lleva;
import hibernateClases2.ResumenCamisetas;
import hibernateClases2.ResumenCamisetasId;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Ejercicio1ExamenHybernate {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            // Configurar Hibernate
            configureHibernate();

            // Llenar la tabla RESUMEN_CAMISETAS
            llenarResumenCamisetas();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    // Configurar Hibernate
    private static void configureHibernate() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Camisetas.class)
                .addAnnotatedClass(Ciclistas.class)
                .addAnnotatedClass(Lleva.class)
                .addAnnotatedClass(ResumenCamisetas.class)
                .addAnnotatedClass(ResumenCamisetasId.class)
                .buildSessionFactory();
            System.out.println("Hibernate configurado correctamente.");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Llenar la tabla RESUMEN_CAMISETAS
    private static void llenarResumenCamisetas() {
        Transaction tx = null;

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();  // Usar org.hibernate.Transaction

            // Obtener todos los registros de Lleva donde el premio de la camiseta es mayor que 0
            List<Lleva> llevaList = session.createQuery("FROM Lleva l JOIN FETCH l.camisetas cam WHERE cam.importepremio > 0", Lleva.class).getResultList();

            System.out.println("Llenar Tabla RESUMEN_CAMISETAS\n");

            // Variable para almacenar el último equipo para comparar con el actual
            Integer lastEquipo = null;
            String lastEquipoNombre = null;

            // Recorrer la lista de Lleva
            for (Lleva lleva : llevaList) {
                int codCamiseta = lleva.getCamisetas().getCodigocamiseta();
                int codCiclista = lleva.getCiclistas().getCodigociclista();
                int codEquipo = lleva.getCiclistas().getEquipos().getCodigoequipo();
                long numVeces = session.createQuery("SELECT COUNT(l) FROM Lleva l WHERE l.camisetas.codigocamiseta = :codCamiseta AND l.ciclistas.codigociclista = :codCiclista", Long.class)
                        .setParameter("codCamiseta", codCamiseta)
                        .setParameter("codCiclista", codCiclista)
                        .getSingleResult();
                double importePremioUnitario = lleva.getCamisetas().getImportepremio();
                double importeTotal = numVeces * importePremioUnitario;

                // Obtener los detalles del ciclista y el equipo
                Ciclistas ciclista = session.get(Ciclistas.class, codCiclista);
                String ciclistaNombre = ciclista != null ? ciclista.getNombreciclista() : "Ciclista desconocido";

                // Obtener el nombre del equipo
                String equipoNombre = session.get(Ciclistas.class, codCiclista).getCiclistas().getEquipos().getNombreequipo().toString();

                // Si el equipo ha cambiado, imprimir los detalles del equipo
                if (lastEquipo == null || !lastEquipo.equals(codEquipo)) {
                    if (lastEquipo != null) {
                        System.out.println("---------------------------------------------------------------------------------------------------");
                    }
                    lastEquipo = codEquipo;
                    lastEquipoNombre = equipoNombre;
                    System.out.println("Equipo: " + codEquipo + ", " + lastEquipoNombre);
                    System.out.println("CAMISETA NºVECES  IMPORTE PREMIO");
                    System.out.println("---------------------------------------------------------------------------------------------------");
                }

                // Insertar en la tabla RESUMEN_CAMISETAS
                ResumenCamisetasId resumenId = new ResumenCamisetasId();
                ResumenCamisetas resumen = new ResumenCamisetas();

                resumenId.setCodigoequipo(codEquipo);
                resumenId.setCodigociclista(codCiclista);
                resumenId.setCodigocamiseta(codCamiseta);

                resumen.setId(resumenId);
                resumen.setNumveces((int) numVeces);
                resumen.setImportepremio((float) importeTotal);

                session.persist(resumen);  // Persistir el resumen

                // Imprimir el ciclista insertado
                System.out.printf("Insertado: %d %s\n", codCiclista, ciclistaNombre);
                System.out.println("  " + numVeces + "     " + importeTotal);
            }

            tx.commit();  // Confirmar la transacción
            System.out.println("\nTabla RESUMEN_CAMISETAS llenada correctamente.");

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
