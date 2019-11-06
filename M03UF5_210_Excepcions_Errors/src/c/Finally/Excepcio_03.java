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
				System.out.println("Posició " + i + " : " + t[i]);
			System.out.println("-->for acabat"); //no s'executarà mai amb aquestes condicions
		}

		//es fa el control d'excepcions individualitzat, és a dir, pot ser diferent segons el tipus d'excepció

		catch(ArrayIndexOutOfBoundsException e){  //entrarà ja que aquesta és l'excepció a gestionar
			System.out.println("Gestió de l'excepció ArrayIndexOutOfBoundsException (1)..." + " " + e.toString());
		}
		
		finally{
			System.out.println("Això s'executarà sempre, encara que vinguem d'un error o excepció (i venia d'un error!!!)");
		}
		
		System.out.println("Final Part 1");
		
		
		//Part 2: finally s'executa encara que no vinguem d'error
		try{
			System.out.println("-->for inici");
			for (int i=0;i<t.length;i++)	//d'aquesta manera no fallarà, però executarà finally igualment
				System.out.println("Posició " + i + " : " + t[i]);
			System.out.println("-->for acabat"); //ara sí sortirà !!!
		}

		//es fa el control d'excepcions individualitzat, és a dir, pot ser diferent segons el tipus d'excepció

		catch(ArrayIndexOutOfBoundsException e){  //entrarà ja que aquesta és l'excepció a gestionar
			System.out.println("Gestió de l'excepció ArrayIndexOutOfBoundsException (1)..." + " " + e.toString());
		}
		
		finally{
			System.out.println("Això s'executarà sempre, encara que vinguem d'un error o excepció (no havia errors previs !!!)");
		}
		
		System.out.println("Final Part 2");
		
	}
	
}
