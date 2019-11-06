package c.Finally;

/*
 * Programa amb control d'excepcions i bloc finally
 */

public class Excepcio_03 {
	public static void main(String args[]){
		String t[]={"Dilluns", "Dimarts", "Dimecres", "Dijous","Divendres", "Dissabte","Diumenge"};

		//Part 1: finally s'executa venint d'error try-catch

		//bloc de codi que s'intenta executar amb control d'excepcions i errors
		try{
			System.out.println("-->for inici");
			for (int i=0;i<=t.length;i++)
				System.out.println("Posici� " + i + " : " + t[i]);
			System.out.println("-->for acabat"); //no s'executar� mai amb aquestes condicions
		}

		//es fa el control d'excepcions individualitzat, �s a dir, pot ser diferent segons el tipus d'excepci�

		catch(ArrayIndexOutOfBoundsException e){  //entrar� ja que aquesta �s l'excepci� a gestionar
			System.out.println("Gesti� de l'excepci� ArrayIndexOutOfBoundsException (1)..." + " " + e.toString());
		}
		
		finally{
			System.out.println("Aix� s'executar� sempre, encara que vinguem d'un error o excepci� (i venia d'un error!!!)");
		}
		
		System.out.println("Final Part 1");
		
		
		//Part 2: finally s'executa encara que no vinguem d'error
		try{
			System.out.println("-->for inici");
			for (int i=0;i<t.length;i++)	//d'aquesta manera no fallar�, per� executar� finally igualment
				System.out.println("Posici� " + i + " : " + t[i]);
			System.out.println("-->for acabat"); //ara s� sortir� !!!
		}

		//es fa el control d'excepcions individualitzat, �s a dir, pot ser diferent segons el tipus d'excepci�

		catch(ArrayIndexOutOfBoundsException e){  //entrar� ja que aquesta �s l'excepci� a gestionar
			System.out.println("Gesti� de l'excepci� ArrayIndexOutOfBoundsException (1)..." + " " + e.toString());
		}
		
		finally{
			System.out.println("Aix� s'executar� sempre, encara que vinguem d'un error o excepci� (no havia errors previs !!!)");
		}
		
		System.out.println("Final Part 2");
		
	}
	
}
