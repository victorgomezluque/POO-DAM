package conrelaciones;

import java.util.Date;

import dao.ModuloDao;
import dao.ProfesorDao;

public class MainDAO {
	
	public static void main(String[] args) {
		ProfesorDao profed = new ProfesorDao();
		ModuloDao modulod = new ModuloDao();
		
		Profesor profesor1=new Profesor("Marc", "Albareda", "Sirvent");
		Profesor profesor2=new Profesor("Gregorio", "Santamaria", "Hernandez");        

		Modulo modulo1=new Modulo(6, new Date(), "Acces a Dades", 8);
		Modulo modulo2=new Modulo(3, new Date(), "Programacio Orientada a Objectes", 8);
		Modulo modulo3=new Modulo(42, new Date(), "Memes Sanos", 8);
		
		Curso dam2 = new Curso(true, 2, CicloFormativo.DAM);
		
		
		//A partir de ahi llamaremos a los DAO, haciendo las operaciones que nos permiten.
		//No tenemos que poreocuparnos de sesiones o transacciones, simplem,ente usar el DAO
		profed.saveOrUpdate(profesor1);
		profed.saveOrUpdate(profesor2);
		
		modulod.saveOrUpdate(modulo1);
		modulod.saveOrUpdate(modulo2);
		modulod.saveOrUpdate(modulo3);
		
		profed.afegirModul(profesor1, modulo1);
		profed.afegirModul(profesor1, modulo3);
		profed.afegirModul(profesor2, modulo2);
		profed.afegirModul(profesor2, modulo3);
		
		profed.afegirModul(profesor1, modulo2);
		
		Profesor grego = profed.get(2);
		System.out.println(grego.getNombre()+" "+grego.getApe1());
		
		

	}
		

}
