
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Instituto2xml {

	public static void main(String[] args) throws Exception {

		Institut insti = llegir();

		System.out.println(insti);

		afegirProfessor("Carlos", "Serrano");

		System.out.println(insti);

		jubilarProfessor("Carlos", "Serrano");

		Alumne Carlos = new Alumne();

		afegirAlumne(Carlos);

		afegirTelefon("48923793D", "1234");

	}

	static Institut llegir() {

		Institut insti = null;

		File file = new File("alumnes.xml");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Institut.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			return insti = (Institut) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	static void alCarrer(String DNI) {
		Institut insti = llegir();
		ArrayList<Alumne> alumne = insti.getAlumnes();
		for (Iterator<Alumne> iterator = alumne.iterator(); iterator.hasNext();) {
			Alumne alumne2 = (Alumne) iterator.next();
			if (alumne2.dni.equals(DNI)) {
				iterator.remove();
			}
		}
		escriure(insti);
	}

	static void escriure(Institut insti) {

		try {
			JAXBContext contextObj = JAXBContext.newInstance(Institut.class);

			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			FileOutputStream fos = new FileOutputStream("institut2.xml");

			marshallerObj.marshal(insti, fos);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	static void afegirProfessor(String nom, String cognom) {

		Institut insti = llegir();

		Professor profe = new Professor(nom, cognom);

		ArrayList<Professor> profes = new ArrayList<Professor>();

		profes = insti.getProfessors();

		profes.add(profe);

		insti.setProfessors(profes);

		escriure(insti);

	}

	static void jubilarProfessor(String nom, String cognom) {
		Institut insti = new Institut();
		insti = llegir();
		ArrayList<Professor> profes = insti.getProfessors();
		for (Iterator<Professor> iterator = profes.iterator(); iterator.hasNext();) {
			Professor professor = (Professor) iterator.next();
			if (professor.getNom().equals(nom) && professor.getCognom().equals(cognom)) {
				iterator.remove();
			} else
				System.out.println("No existeix aquest professor");
		}
		escriure(insti);
	}

	static void afegirAlumne(Alumne a) {

		Institut insti = llegir();

		ArrayList<Alumne> alumnes = new ArrayList<Alumne>();

		alumnes = insti.getAlumnes();

		alumnes.add(a);

		insti.setAlumnes(alumnes);

		escriure(insti);

	}

	static void afegirTelefon(String dni, String telefon) {

		Institut insti = llegir();

		ArrayList<String> telefons = new ArrayList<String>();

		ArrayList<Alumne> alumnes = new ArrayList<Alumne>();

		alumnes = insti.getAlumnes();

		for (Alumne alumne : alumnes) {

			if (alumne.getDni().equals(dni)) {
				telefons = alumne.getTelefons();
				telefons.add(telefon);
				alumne.setTelefons(telefons);
			}

		}

		insti.setAlumnes(alumnes);

		escriure(insti);

	}

}