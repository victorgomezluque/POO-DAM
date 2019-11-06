package e.ExcepcioSuperiorGestionada;

public class Excepcio_05 {
	public static void met03 (){
		String t[]={"Dilluns", "Dimarts", "Dimecres", "Dijous","Divendres", "Dissabte","Diumenge"};

		System.out.println("-->for inici");
		for (int i=0;i<=t.length;i++)
			System.out.println("Posició " + i + " : " + t[i]);
		System.out.println("-->for acabat"); //no s'executarà mai amb aquestes condicions		
	}
	
	public static void met02(){
		System.out.println("Entrem en met02 i anem a executar met03");
		met03();
		System.out.println("Tornem a estar en met02 després de finalitzar met03"); //no s'executarà en aquestes condicions		
	}

	public static void met01(){
		try{
			System.out.println("Entrem en met01 i anem a executar met02");
			met02();
			System.out.println("Tornem a estar en met01 després de finalitzar met02"); //no s'executarà en aquestes condicions
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Excepció caçada al vol !!!");
			System.out.println("Informació que dona el mètode getMessage(): ");
			System.out.println(e.getMessage());
			System.out.println("Informació que dona el mètode printSatckTrace(): ");
			e.printStackTrace();
			System.out.println("Informació que dona el mètode toString(): ");
			System.out.println(e);		
		}
	}
	
	public static void main(String args[]){
		System.out.println("En Main ... apunt de cridar a met01");
		met01();
		System.out.println("En Main ... retornats de met01");  //no s'executarà en aquestes condicions
	}	
}
