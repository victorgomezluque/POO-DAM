package k.altres;

class ExcepcioDAM extends Exception {
	String missatge;
	public ExcepcioDAM(String missatge) {
		this.missatge = missatge;
	}
	
	public String getMissatge() {
       return missatge;
	}
}
 
public class Excepcio_13 {
	public static void main(String[] args) {
		try {
			throw new ExcepcioDAM("La Meva Excepci�");
		} catch(ExcepcioDAM e) {
			System.out.println("excepci�: " + e.getMissatge());
		}        
	}
}