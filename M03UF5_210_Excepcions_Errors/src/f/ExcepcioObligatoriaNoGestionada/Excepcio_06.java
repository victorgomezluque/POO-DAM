package f.ExcepcioObligatoriaNoGestionada;

import java.io.FileOutputStream;
//Errors de compilació ja que les excepcions que es poden generar són de gestió obligada (No deriva de RuntimeExcepcion)
//excepcions possibles: FileNotFoundException i IOException
public class Excepcio_06 {
	public static void main(String args[]){
	//  descomentant les següents línies donarà error de compilació
		
	//	FileOutputStream f = new FileOutputStream ("C:\\arxiu.txt");
	//	f.close();
	}
}
