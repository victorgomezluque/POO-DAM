
import java.io.File;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XML2Gatete {

	public static void main(String[] args) {

		/// <magia negra>

		try {
			// crees un fitxer
			File file = new File("gatete.xml");
			// crees un nou contexte. El contexte ser de la classe ARREL
			JAXBContext jaxbContext = JAXBContext.newInstance(Protectoras.class);
			// crees un unmarshaller. Unmarshaller es llegir i marshaller escriure
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			// fas un unmarshal i castejes directament a la classe que vols
			Protectoras Protectora = (Protectoras) jaxbUnmarshaller.unmarshal(file);
			/// </magia negra>

			System.out.println(Protectora);

	
//
//	File file2 = new File("gatete2.xml");
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//			jaxbMarshaller.marshal(Protectora, file2);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
