package d.ExcepcioSuperiorNoGestionada;

public class Excepcio_04 {
	
	public static void met02 (){
		String t[]={"Dilluns", "Dimarts", "Dimecres", "Dijous","Divendres", "Dissabte","Diumenge"};

		System.out.println("-->for inici");
		for (int i=0;i<=t.length;i++)
			System.out.println("Posici� " + i + " : " + t[i]);
		System.out.println("-->for acabat"); //no s'executar� mai amb aquestes condicions		
	}
	
	public static void met01(){
		System.out.println("Entrem en met01 i anem a executar met02");
		met02();
		System.out.println("Tornem a estar en met01 despr�s de finalitzar met02"); //no s'executar� en aquestes condicions		
	}
	
	public static void main(String args[]){
		System.out.println("En Main ... apunt de cridar a met01");
		met01();
		System.out.println("En Main ... retornats de met01");  //no s'executar� en aquestes condicions
	}
}
