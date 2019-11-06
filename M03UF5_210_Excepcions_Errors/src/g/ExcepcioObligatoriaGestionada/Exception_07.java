package g.ExcepcioObligatoriaGestionada;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exception_07 {

	//delegaci� d'excepcions
	public static void metodeAmbClausulaThrows(String nomFitxer)
				throws FileNotFoundException, IOException  //si es comenta aquesta l�nia tindrem error de compilaci� 
	{

		FileOutputStream f = new FileOutputStream ("C:\\arxiu.txt");
		f.close();
		System.out.println("El metodeAmbClausulaThrows ha finalitzat");
	}
	
	public static void main(String args[]){
		try{
			metodeAmbClausulaThrows("c:\\arxiu.txt");
			System.out.println("Tornats del metodeAmbClausulaThrows");
			System.out.println("Final");
		}
		catch(FileNotFoundException e){
			System.out.println("Excepci�" + e);
		}
		catch(IOException e){
			System.out.println("Excepci�" + e);
		}
		finally{
			System.out.println("Final");
		}
	}

}
