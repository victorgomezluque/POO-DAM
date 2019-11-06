package dao;

import java.util.List;

import conrelaciones.Modulo;
import conrelaciones.Profesor;

//En la interficie siemplemente extendemos IGenericDao y despejamos los gen�ricos
public interface IProfesorDao extends IGenericDao<Profesor,Integer>{

	void saveOrUpdate(Profesor p);

	Profesor get(Integer id);

	List<Profesor> list();

	void delete(Integer id);
	
	//hay un m�todo nuevo!
	boolean afegirModul(Profesor p, Modulo m);

}
