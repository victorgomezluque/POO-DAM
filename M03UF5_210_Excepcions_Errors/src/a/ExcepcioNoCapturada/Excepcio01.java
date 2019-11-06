/*
 * Programa sense cap gestió d'errors ni excepcions.
 * Fallarà en temps d'execució
 */
package a.ExcepcioNoCapturada;

public class Excepcio01 {
	public static void main(String args[]){
		String t[]={"Dilluns", "Dimarts", "Dimecres", "Dijous","Divendres", "Dissabte","Diumenge"};
		for (int i=0;i<=t.length;i++)
			System.out.println("Posició " + i + " : " + t[i]);
		System.out.println("Final");
	}
	
}
