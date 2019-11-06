package projecte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Instituto2xml {

	public static void main(String[] args) throws Exception {

		afegirProfessor("Professor", "Afegit");
		afegirProfessor("Professor", "Eliminat");
		jubilarProfessor("Professor", "Afegit");
		ArrayList<String> telefons = new ArrayList<>();
		Alumne al = new Alumne("alumne1", "afegit", "4982364a", "aderça", telefons, "email");
		Alumne al2 = new Alumne("alumne2", "afegit", "5sda598/7", "aderça", telefons, "email");
		afegirAlumne(al);
		afegirAlumne(al2);
		alCarrer("5sda598/7");
		JSONArray j = llegirJSON();
		escriureJSON(j);
		comprarMaquina("1.6", "maquina", "i7", true);
		canviaMaquina("1-6-1", "C4");
		switchAC("C4");
		Classe classe = crearClasse();
		System.out.println(classe.toString());
		escriureClasse(classe);
		Classe c = llegirClasse();
		System.out.println(c);
	}

	static Institut llegir() {

		File file = new File("alumnes.xml");

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

			FileOutputStream fos = new FileOutputStream("alumnes.xml");

			marshallerObj.marshal(insti, fos);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static JSONArray llegirJSON() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("aules.json"));

			JSONArray jsonObject = (JSONArray) obj;
			return jsonObject;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void escriureJSON(JSONArray j) {
		try (FileWriter file = new FileWriter("aules.json")) {

			file.write(j.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static public void escriureClasse(Classe c) {
		try {
			FileOutputStream file = new FileOutputStream("classe.dat");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(c);
			out.close();
			file.close();
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

	}

	static public Classe llegirClasse() {
		try {

			FileInputStream file = new FileInputStream("classe.dat");
			ObjectInputStream in = new ObjectInputStream(file);

			Classe c = (Classe) in.readObject();

			in.close();
			file.close();
			return c;

		}

		catch (IOException ex) {
			System.out.println(ex);
		}

		catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		return null;
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

	static void alCarrer(String DNI) {
		Institut insti = llegir();
		ArrayList<Alumne> alumne = insti.getAlumnes();
		for (Iterator<Alumne> iterator = alumne.iterator(); iterator.hasNext();) {
			Alumne alumne2 = (Alumne) iterator.next();
			if (alumne2.getDni().equals(DNI)) {
				iterator.remove();
			}
		}
		escriure(insti);
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
		boolean trobat = false;
		ArrayList<Professor> profes = insti.getProfessors();
		for (Iterator<Professor> iterator = profes.iterator(); iterator.hasNext();) {
			Professor professor = (Professor) iterator.next();
			if (professor.getNom().equals(nom) && professor.getCognom().equals(cognom)) {
				iterator.remove();
				trobat=true;
			} 				
		}
		if (!trobat) System.out.println("No existeix aquest professor");
		escriure(insti);
	}

	static void comprarMaquina(String nomAula, String nomMaquina, String processador, boolean grafica) {
		JSONArray j = llegirJSON();
		for (Object o : j) {
			JSONObject aula = (JSONObject) o;
			if (aula.get("nom").equals(nomAula)) {
				JSONArray maquines = (JSONArray) aula.get("maquines");
				boolean existeix = false;
				for (Object m : maquines) {
					JSONObject maquina = (JSONObject) m;
					if (maquina.get("nom").equals(nomMaquina))
						existeix = true;
				}
				if (!existeix) {
					JSONObject ma = new JSONObject();
					ma.put("nom", nomMaquina);
					ma.put("processador", processador);
					ma.put("grafica", grafica);
					maquines.add(ma);
				}
			}
		}
		escriureJSON(j);
	}

	static void switchAC(String nomAula) {

		JSONArray jsonArray = llegirJSON();

		for (Object object : jsonArray) {
			JSONObject aula = (JSONObject) object;

			if (aula.get("nom").equals(nomAula)) {

				Boolean aire = (Boolean) aula.get("aireacondicionat");

				aula.put("aireacondicionat", !aire);

			}

		}

		escriureJSON(jsonArray);

	}

	static void canviaMaquina(String nomMaquina, String a) {
		JSONArray j = llegirJSON();
		JSONObject guardar = new JSONObject();

		for (Object o : j) {
			JSONObject aula = (JSONObject) o;
			JSONArray maquines = (JSONArray) aula.get("maquines");
			for (Iterator iterator = maquines.iterator(); iterator.hasNext();) {
				JSONObject object = (JSONObject) iterator.next();
				if ((boolean) object.get("nom").equals(nomMaquina)) {
					JSONObject maquina = (JSONObject) object;
					guardar = maquina;
					iterator.remove();
				}

			}

		}

		for (Object o : j) {
			JSONObject aula = (JSONObject) o;
			if (aula.get("nom").equals(a)) {
				JSONArray maquines = (JSONArray) aula.get("maquines");
				maquines.add(guardar);
			}
		}

		escriureJSON(j);

	}

	static public Classe crearClasse() {
		Classe classe = new Classe();
		Random rnd = new Random();
		JSONArray aules = llegirJSON();
		classe.setAula((JSONObject) aules.get(rnd.nextInt(aules.size())));
		Institut institut = llegir();
		ArrayList<Alumne> alumnes = institut.getAlumnes();
		ArrayList<Alumne> classeal = classe.getAlumnes();
		int i = 0;
		while (i < 5) {
			Alumne alumne = alumnes.get(rnd.nextInt(alumnes.size()));
			if (!classeal.contains(alumne)) {
				classeal.add(alumne);
				i++;
			}
		}
		classe.setAlumnes(classeal);
		ArrayList<Professor> professors = institut.getProfessors();
		classe.setProfessor(professors.get(rnd.nextInt(professors.size())));
		return classe;
	}

}