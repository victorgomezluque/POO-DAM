package conrelaciones;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Main {

	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;

	public static synchronized SessionFactory getSessionFactory() {
		/// sessionFactory es un Singleton
		if (sessionFactory == null) {

			// exception handling omitted for brevityaa

			/// pilla la configuracion del fichero de configuración
			serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {

		try {
			//una sesion es una conexión a la BD. Pueden haber varias sesiones simultaneas de diferentes usuarios.
			//Lo lógico es que solo haya una en el programa.
			session = getSessionFactory().openSession();
			
			// Una transaccion es atómica. Solo puede haber una y hasta que no se cierra no puede ejecutarse otra, ni siquiera de otro usuario.
			// Una sesión contendrá múltiples transacciones habitualmente
			session.beginTransaction();

			Profesor profesor1 = new Profesor("Marc", "Albareda", "Sirvent");
			Profesor profesor2 = new Profesor("Gregorio", "Gregorio", "No lo se");

			Modulo modulo1 = new Modulo(6, new Date(), "Acces a Dades", 8);
			Modulo modulo2 = new Modulo(3, new Date(), "Programacio Orientada a Objectes", 8);
			Modulo modulo3 = new Modulo(42, new Date(), "Memes Sanos", 8);

			Curso dam2 = new Curso(true, 2, CicloFormativo.DAM);

			profesor1.getModulos().add(modulo1);
			profesor1.getModulos().add(modulo3);
			profesor2.getModulos().add(modulo2);
			profesor2.getModulos().add(modulo3);

			modulo1.getProfesores().add(profesor1);
			modulo2.getProfesores().add(profesor2);
			modulo3.getProfesores().add(profesor1);
			modulo3.getProfesores().add(profesor2);

			dam2.setTutor(profesor2);
			System.out.println(dam2.getModulos());
			dam2.getModulos().add(modulo1);
			dam2.getModulos().add(modulo2);

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(profesor1);
			session.save(profesor2);
			session.save(dam2);
			modulo1.setCurso(dam2);
			modulo2.setCurso(dam2);
			session.save(modulo1);
			session.save(modulo2);
			session.save(modulo3);

			session.getTransaction().commit();

			session.beginTransaction();
			/*
			 * Modulo memes = session.get(Modulo.class, 42); for(Profesor p :
			 * memes.getProfesores()) { System.out.println(p.getNombre()+" "+p.getApe1()); }
			 */

			//createQuery crea una query en formato de Java Persistence Query
			//teneis ejemplos de Java Persistence Query aqui: https://docs.oracle.com/javaee/6/tutorial/doc/bnbrg.html
			//list devuelve los resultados como una lista para fácil acceso
			List<Object> todoslosmodulos = session.createQuery("FROM Modulo").list();

			for (Object o : todoslosmodulos) {
				Modulo m = (Modulo) o;
				if (m.getNombre().toLowerCase().contains("memes")) {
					System.out.println(m.getIdModulo());
					for (Profesor p : m.getProfesores()) {
						System.out.println(p.getNombre() + " " + p.getApe1());
					}
				}
			}

			///El commit guarda los cambios hechos en la BD. Hasta que no se hace un commit los cambios no estan
			session.getTransaction().commit();
			System.out.println("Todo ha salido a pedir de Milhouse");

		} catch (HibernateException e) {
			e.printStackTrace();
			//si fallase la generacion de sesion y fuese null eso seria una excepcion que lanzaria otra excepcion encadenada.
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				//haces rollback de la transaccion. los cambios no se efectuan para TODA la transaccion
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			
			//finally, lo ejecuta tanto si hace el try correctamente como si hay excepcion y salta el catch
		} finally {
			if (session != null) {
				//cierra la sesion si existe
				session.close();
			}
		}

	}
}