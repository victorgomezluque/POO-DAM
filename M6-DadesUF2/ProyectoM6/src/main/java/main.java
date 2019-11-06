
import javax.imageio.spi.ServiceRegistry;

import org.hibernate.SharedSessionContract;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

public class main {

	static User user;
	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;

	public static synchronized SessionFactory getSessionFactory() {
		/// sessionFactory es un Singleton
		if (sessionFactory == null) {

			// exception handling omitted for brevityaa

			/// pilla la configuracion del fichero de configuraci�n
			serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
					.build();

			sessionFactory = (SessionFactory) new MetadataSources().buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		/// abrimos sesion. Eso se hace siempre
		try {
			// una sesion es una conexi�n a la BD. Pueden haber varias sesiones simultaneas
			// de diferentes usuarios.
			// Lo l�gico es que solo haya una en el programa.
			session = (Session) ((org.hibernate.SessionFactory) getSessionFactory()).openSession();

			// abrimos PRIMERA transaccion. Eso se hace siempre.
			// Una transaccion es at�mica. Solo puede haber una y hasta que no se cierra no
			// puede ejecutarse otra, ni siquiera de otro usuario.
			// Una sesi�n contendr� m�ltiples transacciones habitualmente
			((SharedSessionContract) session).beginTransaction();

			// creamos un nuevo profesor
			User user = new User("victor","hola.11","jefeDeJefes",ysdate,"hola",(double) 1);
			// CRUD
			// CREATE
			// READ
			// UPDATE
			// DELETE

			// saveorupdate te hace save o update dependiendo si el objeto ya existiese. Es
			// m�s comodo.
			((org.hibernate.Session) session).saveOrUpdate(user);
			
			/// El commit guarda los cambios hechos en la BD. Hasta que no se hace un commit
			/// los cambios no estan
			((SharedSessionContract) session).getTransaction().commit();
			System.out.println("todo ha salido a pedir de Milhouse");
		} catch (Exception sqlException) {
			// si salta una excepcion
			sqlException.printStackTrace();
			if (null != ((SharedSessionContract) session).getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				// haces rollback de la transaccion. los cambios no se efectuan para TODA la
				// transaccion
				((SharedSessionContract) session).getTransaction().rollback();
			}
			sqlException.printStackTrace();
			// finally significa: hazlo tanto si ha fucnionado bien el try como si ha
			// saltado la excepcion
		} finally {
			if (session != null) {
				session.forceClose();
			}
		}
	}

}
