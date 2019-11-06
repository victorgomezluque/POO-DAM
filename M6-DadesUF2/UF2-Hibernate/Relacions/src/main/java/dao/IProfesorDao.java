package dao;

import java.util.List;

import conrelaciones.Modulo;
import conrelaciones.Profesor;

//En la interficie siemplemente extendemos IGenericDao y despejamos los genéricos
public interface IProfesorDao extends IGenericDao<Profesor,Integer>{

	void saveOrUpdate(Profesor p);

	Profesor get(Integer id);

	List<Profesor> list();

	void delete(Integer id);
	
	//hay un método nuevo!
	boolean afegirModul(Profesor p, Modulo m);

}
