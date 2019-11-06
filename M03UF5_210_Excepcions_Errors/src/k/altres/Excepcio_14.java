package k.altres;

import java.io.*;

public class Excepcio_14 {
	public static void main(String[] args) {
		boolean continuar = true; 
		while(continuar) {        
			try {                
				System.out.print("Digues un número enter: ");
				InputStreamReader datosInsertados = new InputStreamReader(System.in);
				BufferedReader datos = new BufferedReader(datosInsertados);
				String cadenaDatos = datos.readLine();
				int numero = Integer.parseInt(cadenaDatos);
				int cuadrado = numero * numero;
				System.out.println("El quadrat de " + numero + " és " + cuadrado);
				continuar = false;
			} catch(Exception e) {
				System.out.println("Si us plau, un número enter!!!");                
			}            
		};           
	}
}