package conrelaciones;

import java.util.Date;
import java.util.HashSet;

public class CosasdeEquals {
	
	public static void main(String[] args) {
		
		HashSet<Modulo> m = new HashSet<>();
		Modulo p1 = new Modulo(1,new Date(), "Sistemas feat. Juan Carlos", 8);
		Modulo p2 = new Modulo(1,new Date(), "Sistemas feat. Pere Tomas", 8);
		
		m.add(p1);
		m.add(p2);
		System.out.println(m);
		
		
		
	}

}
