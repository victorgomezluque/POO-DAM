/*
 * Programa amb control d'excepcions
 */
package b.ExcepcioCapturada;

public class Excepcio_02 {
	public static void main(String args[]){
		String t[]={"Dilluns", "Dimarts", "Dimecres", "Dijous","Divendres", "Dissabte","Diumenge"};

		//PART 1 --> Control Genèric d'Excepcions
		//bloc de codi que s'intenta executar amb control d'excepcions i errors
		try{
			System.out.println("-->for inici");
			for (int i=0;i<=t.length;i++)
				System.out.println("Posició " + i + " : " + t[i]);	//acabarà fallant
			System.out.println("-->for acabat"); //no s'executarà mai amb aquestes condicions
		}
		//gestió genèrica d'excepcions. Entrarà si falla alguna cosa.
		catch(Exception e){
			System.out.println("Gestió genèrica d'excepcions..." + " " + e.toString());
		}

		System.out.println("Final Part 1");
		
		//PART 2 -->  Control específic d'excepcions
		//bloc de codi que s'intenta executar amb control d'excepcions i errors
		try{
			System.out.println("-->for inici");
			for (int i=0;i<=t.length;i++)
				System.out.println("Posició " + i + " : " + t[i]);
			System.out.println("-->for acabat"); //no s'executarà mai amb aquestes condicions
		}

		//es fa el control d'excepcions individualitzat, és a dir, pot ser diferent segons el tipus d'excepció
		catch(NullPointerException e){	  //no entrarà ja que no és aquesta l'excepció a tractar
			System.out.println("Gestió de l'excepció NullPointerException (1)..." + " " + e.toString());
		}

		catch(ArrayIndexOutOfBoundsException e){  //entrarà ja que aquesta és l'excepció a gestionar
			System.out.println("Gestió de l'excepció ArrayIndexOutOfBoundsException (1)..." + " " + e.toString());
		}
		System.out.println("Final Part 2");
		
		//PART 3 --> Control erroni d'exepcions
		//bloc de codi que s'intenta executar amb control d'excepcions i errors
		try{
			System.out.println("-->for inici");
			for (int i=0;i<=t.length;i++)
				System.out.println("Posició " + i + " : " + t[i]);
			System.out.println("-->for acabat"); //no s'executarà mai amb aquestes condicions
		}

		//es fa el control d'excepcions individualitzat, és a dir, pot ser diferent segons el tipus d'excepció
		catch(NullPointerException e){	  //no entrarà ja que no és aquesta l'excepció a tractar
			System.out.println("Gestió de l'excepció NullPointerException (1)..." + " " + e.toString());
		}
		//el bloc catch no ha resolt correctament l'excepció. EL programa fallarà.

		System.out.println("Final Part 3");  //no s'imprimirà
		
	}
	
}