package InterceptorsEvents;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

import conrelaciones.Profesor;


public class LoadEventListenerImp implements LoadEventListener {
   
   private static final long serialVersionUID = 1L;
   
   @Override
   public void onLoad(LoadEvent e, LoadType type) throws HibernateException {
     Object obj = e.getResult();
      if (obj instanceof Profesor) {
    	 Profesor p = (Profesor) obj;
        
      }
   }

}