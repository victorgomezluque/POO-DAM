package k.altres;

public class Excepcio_11  {
    public static void main(String[] args){
    	try {
    		throw new Exception("Aix� �s una excepci�");
	   } catch(Exception e) {
		   System.out.println("S'ha produit una excepci�: " + e.getMessage());
	   } finally {
		   System.out.println("Aix� s'executa sempre");
	   }
	  }
 }

