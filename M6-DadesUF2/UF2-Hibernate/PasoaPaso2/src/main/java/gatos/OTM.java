package gatos;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class OTM {

	static GatoOTM gato;
	static Caixa caja;
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
			
			//creamos un gato
			GatoOTM gato = new GatoOTM();
			gato.setId(1);
			gato.setNombre("kernel");
			gato.setEdad(7);
			gato.setRaza("mezcla");
			gato.setFecha(new Date());
			gato.setCapado(true);
			
			//creamos un set de cajas. Es un set porque no querriamos que se repitiese ninguna (son llaves primarias)
			Set<Caixa> cajas = new HashSet<Caixa>();
			for (int i = 200; i < 210; i++) {
				Caixa caja = new Caixa(i, "algo", true);
				//le ponemos que su llave foranea es el gato que hemos creado antes, kernel.
				caja.setGatootm(gato);
				//lo añadimos al set
				cajas.add(caja);
				
			}
			//ponemos todas las cajas del gato
			gato.setCaixa(cajas);
			session.saveOrUpdate(gato);
			
			//tenemos que guardar los objetos foraneos DESPUES de guardar el principal. si no peta
			for(Caixa c : cajas) {
				session.saveOrUpdate(c);
			}
			
			
			
			
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
