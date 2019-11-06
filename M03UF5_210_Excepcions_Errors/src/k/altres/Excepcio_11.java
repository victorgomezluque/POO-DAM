package k.altres;

public class Excepcio_11  {
    public static void main(String[] args){
    	try {
    		throw new Exception("Això és una excepció");
	   } catch(Exception e) {
		   System.out.println("S'ha produit una excepció: " + e.getMessage());
	   } finally {
		   System.out.println("Això s'executa sempre");
	   }
	  }
 }

