ypackage j.CreacioExcepcions;

public class LaMevaExcepcio extends Exception{
	private Integer valor;
	
	public LaMevaExcepcio (int xxx){
		valor = new Integer(xxx);
	}
	
	public String toString(){
		return "Exception LaMevaExcepcio: Error motiva pel valor = " + valor.toString();
	}
}
