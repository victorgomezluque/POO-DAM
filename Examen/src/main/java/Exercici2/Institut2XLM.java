package Exercici2;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Exercici3.Alumne;

public class Institut2XLM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Institut insti = llegir();
		//System.out.println(insti);

		EliminaFitxers("28923792Z");
		System.out.println(insti);

	}

	static void EliminaFitxers(String DNI) {
		Institut insti = llegir();
		ArrayList<Alumne> alumnes = insti.getAlumnes();
		ArrayList<Professor> professors = insti.getProfessors();
		System.out.println(professors);
		//Te añado un profesor para que veas que se puede leer y escibir
		Professor prof = new Professor("hoasla", "deu", "1111111", "C/hola", null, "a@a.com");
		professors.add(prof);
//		for (Iterator iterator = professors.iterator(); iterator.hasNext();) {
//			Professor professor = (Professor) iterator.next();
//			String[] tel = professor.getTelefons().get(1).toString().split("");
//			if (tel[0].equals("9")) {
//				iterator.remove();
//			}
//			
//
//		}
		//System.out.println(professors);

		escriure(insti);

	}

	static Institut llegir() {

		File file = new File("institut.xml");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Institut.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Institut insti;
			return insti = (Institut) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	static void escriure(Institut insti) {

		try {
			JAXBContext contextObj = JAXBContext.newInstance(Institut.class);

			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			FileOutputStream fos = new FileOutputStream("institut.xml");

			marshallerObj.marshal(insti, fos);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
