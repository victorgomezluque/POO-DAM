/*
 * Programa sense cap gesti� d'errors ni excepcions.
 * Fallar� en temps d'execuci�
 */
package a.ExcepcioNoCapturada;

public class Excepcio01 {
	public static void main(String args[]){
		String t[]={"Dilluns", "Dimarts", "Dimecres", "Dijous","Divendres", "Dissabte","Diumenge"};
		for (int i=0;i<=t.length;i++)
			System.out.println("Posici� " + i + " : " + t[i]);
		System.out.println("Final");
	}
	
}
