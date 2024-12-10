package hybernate;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateClases.Departamentos;

public class EjemploHibernate {

	public static void main(String[] args) {
		// Inicializa el entorno Hibernate
		Configuration cfg = new Configuration().configure();
		
		// Crea el ejemplar de sesion factory (fabrica de sesiones)
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// Obtiene un objeto session
		Session sesion = sessionFactory.openSession();
		Transaction tx = sesion.beginTransaction();
		System.out.println("Inserto una fila en la tabla DEPARTAMENTOS.");
		Departamentos dep = new Departamentos();
		dep.setDeptNo((byte) 62);
		dep.setDnombre("MARKETING");
		dep.setLoc("GUADALAJARA");
		
		
		try {
			sesion.persist(dep);
			tx.commit();
			System.out.println("REGISTRO GRABADO ");
		} catch (JDBCException j) {
			System.out.println("Codigo error: " + j.getErrorCode());
			System.out.println("Mensaje : " + j.getMessage());
			// 1406 Datos sobrepasan long de la columna
			// 1062 Clave duplicada
		} catch (Exception e) {
			System.out.println("Codigo error: " + e.hashCode());
			System.out.println("Mensaje : " + e.getMessage());
		}
		sesion.close();
	}

}
