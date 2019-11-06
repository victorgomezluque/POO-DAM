package Llops;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;

	public static synchronized SessionFactory getSessionFactory() {
		///sessionFactory es un Singleton
		if (sessionFactory == null) {

			// exception handling omitted for brevityaa

			///pilla la configuracion del fichero de configuraci�n
			serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		/// abrimos sesion. Eso se hace siempre
		try {
			//una sesion es una conexi�n a la BD. Pueden haber varias sesiones simultaneas de diferentes usuarios.
			//Lo l�gico es que solo haya una en el programa.
			session = getSessionFactory().openSession();

			// abrimos PRIMERA transaccion. Eso se hace siempre.
			// Una transaccion es at�mica. Solo puede haber una y hasta que no se cierra no puede ejecutarse otra, ni siquiera de otro usuario.
			// Una sesi�n contendr� m�ltiples transacciones habitualmente
			session.beginTransaction();

			// creamos un nuevo profesor
			User u = new User("malbareda", "super3", "marc", "http://algo");
			
			// CRUD
			// CREATE
			// READ
			// UPDATE
			// DELETE
			
			// saveorupdate te hace save o update dependiendo si el objeto ya existiese. Es
			// m�s comodo.
			session.saveOrUpdate(u);
		
			///El commit guarda los cambios hechos en la BD. Hasta que no se hace un commit los cambios no estan
			session.getTransaction().commit();
			System.out.println("todo ha salido a pedir de Milhouse");
		} catch (Exception sqlException) {
			//si salta una excepcion
			sqlException.printStackTrace();
			if (null != session.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				//haces rollback de la transaccion. los cambios no se efectuan para TODA la transaccion
				session.getTransaction().rollback();
			}
			//finally significa: hazlo tanto si ha fucnionado bien el try como si ha saltado la excepcion
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
