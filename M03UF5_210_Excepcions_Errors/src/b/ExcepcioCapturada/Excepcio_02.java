/*
 * Programa amb control d'excepcions
 */
package b.ExcepcioCapturada;

public class Excepcio_02 {
	public static void main(String args[]){
		String t[]={"Dilluns", "Dimarts", "Dimecres", "Dijous","Divendres", "Dissabte","Diumenge"};

		//PART 1 --> Control Gen�ric d'Excepcions
		//bloc de codi que s'intenta executar amb control d'excepcions i errors
		try{
			System.out.println("-->for inici");
			for (int i=0;i<=t.length;i++)
				System.out.println("Posici� " + i + " : " + t[i]);	//acabar� fallant
			System.out.println("-->for acabat"); //no s'executar� mai amb aquestes condicions
		}
		//gesti� gen�rica d'excepcions. Entrar� si falla alguna cosa.
		catch(Exception e){
			System.out.println("Gesti� gen�rica d'excepcions..." + " " + e.toString());
		}

		System.out.println("Final Part 1");
		
		//PART 2 -->  Control espec�fic d'excepcions
		//bloc de codi que s'intenta executar amb control d'excepcions i errors
		try{
			System.out.println("-->for inici");
			for (int i=0;i<=t.length;i++)
				System.out.println("Posici� " + i + " : " + t[i]);
			System.out.println("-->for acabat"); //no s'executar� mai amb aquestes condicions
		}

		//es fa el control d'excepcions individualitzat, �s a dir, pot ser diferent segons el tipus d'excepci�
		catch(NullPointerException e){	  //no entrar� ja que no �s aquesta l'excepci� a tractar
			System.out.println("Gesti� de l'excepci� NullPointerException (1)..." + " " + e.toString());
		}

		catch(ArrayIndexOutOfBoundsException e){  //entrar� ja que aquesta �s l'excepci� a gestionar
			System.out.println("Gesti� de l'excepci� ArrayIndexOutOfBoundsException (1)..." + " " + e.toString());
		}
		System.out.println("Final Part 2");
		
		//PART 3 --> Control erroni d'exepcions
		//bloc de codi que s'intenta executar amb control d'excepcions i errors
		try{
			System.out.println("-->for inici");
			for (int i=0;i<=t.length;i++)
				System.out.println("Posici� " + i + " : " + t[i]);
			System.out.println("-->for acabat"); //no s'executar� mai amb aquestes condicions
		}

		//es fa el control d'excepcions individualitzat, �s a dir, pot ser diferent segons el tipus d'excepci�
		catch(NullPointerException e){	  //no entrar� ja que no �s aquesta l'excepci� a tractar
			System.out.println("Gesti� de l'excepci� NullPointerException (1)..." + " " + e.toString());
		}
		//el bloc catch no ha resolt correctament l'excepci�. EL programa fallar�.

		System.out.println("Final Part 3");  //no s'imprimir�
		
	}
	
}