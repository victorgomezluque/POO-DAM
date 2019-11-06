package i.LlançamentExcepcioGestioObligatoriaRuntime;

public class Excepcio_09 {

	// amb RuntimeException no és obligat gestionar excepcions, ni delegarles
	public static void verificaLengthTaula(int n, String t[]) 
	{
		if (t.length!=n) throw new RuntimeException ("La taula no té la llargada indicada");
		System.out.println("Sortida de verificaLengthTaula");
	}
	
	public static void main(String args[]){
		System.out.println("Punt 1");
		verificaLengthTaula(4,new String[4]);
		System.out.println("Punt 2");
		verificaLengthTaula(2,new String[4]);
		System.out.println("Punt 3");
		verificaLengthTaula(4,new String[4]);
		System.out.println("Programa finalitzat");
	}

}
