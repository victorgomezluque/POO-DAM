package problemes.pintures.test;

import problemes.pintures.Color;
import problemes.pintures.Comanda;
import problemes.pintures.MagatzemPintura;
import problemes.pintures.ProveidorPintura;
import problemes.pintures.impl.MagatzemPinturaImpl;
import problemes.pintures.impl.ProveidorPinturaImpl;

/*
 * Resultat esperat:
 *  
no hi ha proveidor cian: null
estoc del proveidor groc: 50
tots els estocs dels proveidors: {GROC=50, NEGRE=75}
comandes pendents: [Comanda [quantitat=15, color=GROC], Comanda [quantitat=25, color=NEGRE]]
 *
 */
public class MagatzemTest {

	public static void main(String[] args) {
		
		MagatzemPintura m = new MagatzemPinturaImpl();		
		ProveidorPintura pGroc = new ProveidorPinturaImpl(Color.GROC, 50, 10);
		ProveidorPintura pNegre = new ProveidorPinturaImpl(Color.NEGRE, 75, 15);
		
		m.afegirProveidor(pGroc);
		m.afegirProveidor(pNegre);
		
		System.out.println("no hi ha proveidor cian: " + m.getProveidor(Color.CIAN));		
		System.out.println("estoc del proveidor groc: " + m.getProveidor(Color.GROC).getEstoc());
				
		System.out.println("tots els estocs dels proveidors: " + m.getEstocProveidors());
		
		m.afegirComanda(new Comanda(Color.GROC, 15));
		m.afegirComanda(new Comanda(Color.NEGRE, 25));

		System.out.println("comandes pendents: " + m.getComandesPendents());
	}
}
