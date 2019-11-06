package Exercici3;

import java.io.FileOutputStream;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Exercici2.Institut;

public class Jsontoxml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONArray j = llegirJSON();
		System.out.println(j.toJSONString());
		

	}
	
	static void escriure(Alumne a) {

		try {
			JAXBContext contextObj = JAXBContext.newInstance(Alumne.class);

			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			FileOutputStream fos = new FileOutputStream("alumne.xml");

			marshallerObj.marshal(a, fos);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

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

}
