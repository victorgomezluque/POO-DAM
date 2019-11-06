package pintures.test;

import pintures.Color;
import pintures.ProveidorPintura;
import pintures.impl.ProveidorPinturaImpl;

/*
 * Resultat esperat:
 *  
color: GROC
estoc inicial: 50
quantitat mínima: 10
demano 20, retiro 20 i queda 30
demano 5, retiro 10 i queda 20
demano 25, retiro 0 i queda 20
produeixo 10
demano 25, retiro 25 i queda 5
 *
 */
public class ProveidorTest {

	public static void main(String[] args) {
	
		ProveidorPintura p = new ProveidorPinturaImpl(Color.GROC, 50, 10);
		
		System.out.println("color: " + p.getColor());
		System.out.println("estoc inicial: " + p.getEstoc());
		System.out.println("quantitat mínima: " + p.getQuantitatMinima());
		
		int demano, retirat;
		
		demano = 20;
		retirat = p.retirarPintura(demano);		
		System.out.println("demano " + demano + ", retiro " + retirat + " i queda " + p.getEstoc());
				
		demano = 5; 
		retirat = p.retirarPintura(demano);		
		System.out.println("demano " + demano + ", retiro " + retirat + " i queda " + p.getEstoc());
		
		demano = 25;
		retirat = p.retirarPintura(demano);		
		System.out.println("demano " + demano + ", retiro " + retirat + " i queda " + p.getEstoc());
		
		int produir = 10;
		p.produirPintura(produir);
		System.out.println("produeixo " + produir);
		
		retirat = p.retirarPintura(demano);
		System.out.println("demano " + demano + ", retiro " + retirat + " i queda " + p.getEstoc());
	}
}
