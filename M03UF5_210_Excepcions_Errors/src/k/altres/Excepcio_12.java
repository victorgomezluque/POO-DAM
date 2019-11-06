package k.altres;

public class Excepcio_12 {
	String s = "Exercici sobre Excepcions";
	String getString() {
		return s;
	 }
	   
	public static void main(String[] args) {
		Excepcio_12 en = null;
		try {
			en.getString();
		} catch (Exception e){
			System.out.println("Excepció !!! " + e.getMessage());
		}
	}
}