package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import conrelaciones.Modulo;
import conrelaciones.Profesor;


//Solo es necesario implementar el nuevo modulo
public class ProfesorDao extends GenericDao<Profesor,Integer> implements IProfesorDao {

	@Override
	public boolean afegirModul(Profesor p, Modulo m) {
		if(p.getHorasAsignadas()+m.getHorasSemana()>20) {
			System.out.println("No se puede asociar Modulo, se sobrepasan las horas asignadas");
			return false;
		}else {
			Session session = sessionFactory.getCurrentSession();
			p.getModulos().add(m);
			m.getProfesores().add(p);
			p.setHorasAsignadas(p.getHorasAsignadas()+m.getHorasSemana());
			try {
				session.beginTransaction();
				session.saveOrUpdate(p);
				session.saveOrUpdate(m);
				
				session.getTransaction().commit();
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				if (session != null && session.getTransaction() != null) {
					System.out.println("\n.......Transaction Is Being Rolled Back.......");
					session.getTransaction().rollback();
				}
				e.printStackTrace();
				return false;

			}
		}
		
	}
}
