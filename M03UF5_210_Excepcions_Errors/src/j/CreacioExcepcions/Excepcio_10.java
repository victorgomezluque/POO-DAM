package j.CreacioExcepcions;

public class Excepcio_10 {
	public static void main(){
		try {
			provocoExcepcio(0);
			provocoExcepcio(10);
		} catch (LaMevaExcepcio e){
			e.printStackTrace();
			
		}
		System.out.println("Programa acaba correctament");
	}
	
	public static void provocoExcepcio(int valor) throws LaMevaExcepcio{
		System.out.println("Valor: " + valor);
		if (valor!=0) throw new LaMevaExcepcio(valor);
		System.out.println("No s'ha provocat l'excepció");
	}
}
