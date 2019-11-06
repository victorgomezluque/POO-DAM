package Exercici3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Exercici2.Institut;


public class xmlToJson {
	public static void main(String[] args) {
		Alumne alu = llegir();
		JSONObject alumn = new JSONObject();
		alumn.put("nom", alu.getNom());
		alumn.put("Cognom", alu.getCognoms());
		alumn.put("Dni", alu.getDni());
		alumn.put("Adreça", alu.getAdreca());
		alumn.put("telefons", alu.getTelefons());
		alumn.put("mail", alu.getMail());
		
		escriureJSON(alumn);
		llegirJSON();

		
		
	}
	
	public static JSONArray llegirJSON() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("alumne.json"));

			JSONArray jsonObject = (JSONArray) obj;
			return jsonObject;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void escriureJSON(JSONObject alumn) {
		try (FileWriter file = new FileWriter("alu.json")) {

			file.write(alumn.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	static Alumne llegir() {

		File file = new File("Alumne.xml");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Institut.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Alumne alumne;
			return alumne = (Alumne) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
