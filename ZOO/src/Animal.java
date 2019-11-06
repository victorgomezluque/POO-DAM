import java.util.Random;

public abstract class Animal implements Esser {

	 abstract String mou(Zoo zoo);
	 abstract String alimenta(Zoo zoo);
	 abstract String expresa(Zoo zoo);
	
	 String accio(Zoo zoo) {
		Random rnd = new Random(3);
		int i = rnd.nextInt();
		
		switch(i){
		case 0:
			return mou(zoo);
			

		case 1:
			return alimenta(zoo);
			

		case 2:
			return expresa(zoo);
			
			
		default:
			return null;
		}
		
		
		
		
	}
	
	
}
