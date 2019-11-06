package h.LlançamentExcepcioGestioObligatoria;

public class Excepcio_08 {
	public static void verificaLengthTaula(int n, String t[]) throws Exception
	{
		if (t.length!=n) throw new Exception ("La taula no té la llargada indicada");
		System.out.println("Sortida de verificaLengthTaula");
	}
	
	public static void main(String args[]){
		try{
			System.out.println("Punt 1");
			verificaLengthTaula(4,new String[4]);
			System.out.println("Punt 2");
			verificaLengthTaula(2,new String[4]);
			System.out.println("Punt 3");
			verificaLengthTaula(4,new String[4]);
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("Programa finalitzat");
	}

}
