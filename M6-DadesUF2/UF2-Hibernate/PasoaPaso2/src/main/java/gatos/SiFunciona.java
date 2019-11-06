package gatos;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class SiFunciona {

	static Employee empleado;
	static Address direccion;
	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry; 
	
	
	public static synchronized SessionFactory getSessionFactory() {
	    if ( sessionFactory == null ) {

	        // exception handling omitted for brevityaa

	        serviceRegistry = new StandardServiceRegistryBuilder()
	                .configure("hibernate.cfg.xml")
	                .build();

	        sessionFactory = new MetadataSources( serviceRegistry )
	                    .buildMetadata()
	                    .buildSessionFactory();
	    }
	    return sessionFactory;
	}
	
	
	public static void main(String[] args) {
		///abrimos sesion. Eso se hace siempre
		try {
			session = getSessionFactory().openSession();
			
			//abrimos PRIMERA transaccion. Eso se hace siempre.
			session.beginTransaction();
			
			for (int i = 200; i < 210; i++) {
				Address dir = new Address();
				dir.setId(i);
				dir.setStreet("carrer"+i+", 1");
				dir.setCity("Sabadell");
				dir.setState("catalunya");
				dir.setZipcode("08205");
				session.saveOrUpdate(dir);
				Employee emp = new Employee(i,"Marc"+i, "Albareda", i, dir);
				session.saveOrUpdate(emp);
			}
			
			
			Employee marc = session.get(Employee.class, 200);
			
			System.out.println(marc);
			System.out.println(marc.getLastName());
			System.out.println(marc.getAddress().getStreet());
			
			/*
			Random r = new Random();
			
			for(int i = 200; i<210; i++) {
				Gato gato = new Gato();
				gato.setId(i);
				gato.setNombre("gatete "+(i-100));
				gato.setEdad(0);
				gato.setRaza("Persa");
				gato.setCapado(r.nextBoolean());
				gato.setFecha(new Date());
				
				session.saveOrUpdate(gato);
			}
			
			
			
			
			
			Gato gatetecientouno = session.get(Gato.class, 101);
			System.out.println(gatetecientouno.getNombre());
			gatetecientouno.setNombre("kernel");
			session.saveOrUpdate(gatetecientouno);
			
			
			session.getTransaction().commit();
			
	        session.beginTransaction();
	         
	         List<Object> todoslosgatos = session.createQuery("FROM Gato").list();
	         int capados = 0;
	         for (Object o : todoslosgatos){
	            Gato g = (Gato)o;
	            
	            System.out.println("El gatete "+g.getNombre()+" esta capado "+g.isCapado());
	            if(g.isCapado()) {
	            	capados++;
	            }
	         }
	         
	         System.out.println("hay "+capados+" gatetes capados");
	         
	         */
	         session.getTransaction().commit();
			System.out.println("todo ha salido a pedir de Milhouse");
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
			if(null != session.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		

	}
}
