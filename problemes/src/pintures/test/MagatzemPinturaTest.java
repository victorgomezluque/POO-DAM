package pintures.test;

import java.util.List;

import pintures.Color;
import pintures.Comanda;
import pintures.MagatzemPintura;
import pintures.ProveidorPintura;
import pintures.impl.MagatzemPinturaImpl;
import pintures.impl.ProveidorPinturaImpl;

/*
 * Resultat esperat:
 * 
===> INICIAL
pendents: [Comanda [quantitat=5, color=CIAN], Comanda [quantitat=15, color=GROC], 
Comanda [quantitat=25, color=NEGRE], Comanda [quantitat=10, color=CIAN], 
Comanda [quantitat=80, color=MAGENTA]]
magatzem: {}
proveïdors: {GROC=50, CIAN=50, MAGENTA=50, NEGRE=50}

===> PROCESSAMENT
fetes: [Comanda [quantitat=5, color=CIAN], Comanda [quantitat=15, color=GROC], 
Comanda [quantitat=25, color=NEGRE], Comanda [quantitat=10, color=CIAN]]
pendents: [Comanda [quantitat=80, color=MAGENTA]]
magatzem: {GROC=0, CIAN=5, NEGRE=0}
proveïdors: {GROC=35, CIAN=30, MAGENTA=50, NEGRE=25}

===> PRODUCCIÓ magenta 50
proveïdors: {GROC=35, CIAN=30, MAGENTA=100, NEGRE=25}

===> PROCESSAMENT
fetes: [Comanda [quantitat=80, color=MAGENTA]]
pendents: []
magatzem: {GROC=0, CIAN=5, NEGRE=0, MAGENTA=0}
proveïdors: {GROC=35, CIAN=30, MAGENTA=20, NEGRE=25}
 *
 */
public class MagatzemPinturaTest {
	
	public static void main(String[] args) {
		
		MagatzemPintura m = new MagatzemPinturaImpl();
		
		// afegeix proveidors
		
		ProveidorPintura pCian = new ProveidorPinturaImpl(Color.CIAN, 50, 10);
		ProveidorPintura pMagenta = new ProveidorPinturaImpl(Color.MAGENTA, 50, 10);
		ProveidorPintura pGroc = new ProveidorPinturaImpl(Color.GROC, 50, 10);
		ProveidorPintura pNegre = new ProveidorPinturaImpl(Color.NEGRE, 50, 10);
		
		m.afegirProveidor(pCian);
		m.afegirProveidor(pMagenta);
		m.afegirProveidor(pGroc);
		m.afegirProveidor(pNegre);
		
		// afegeix comandes
		
		m.afegirComanda(new Comanda(Color.CIAN, 5));
		m.afegirComanda(new Comanda(Color.GROC, 15));
		m.afegirComanda(new Comanda(Color.NEGRE, 25));
		m.afegirComanda(new Comanda(Color.CIAN, 10));
		m.afegirComanda(new Comanda(Color.MAGENTA, 80));
		
		List<Comanda> fetes;
		
		System.out.println("===> INICIAL");
		
		System.out.println("pendents: " + m.getComandesPendents());
		System.out.println("magatzem: " + m.getEstocMagatzem());
		System.out.println("proveïdors: " + m.getEstocProveidors());
		
		// processa comandes
		
		fetes = m.processarComandes();
				
		System.out.println("\n===> PROCESSAMENT");
		
		System.out.println("fetes: " + fetes);		
		System.out.println("pendents: " + m.getComandesPendents());
		System.out.println("magatzem: " + m.getEstocMagatzem());
		System.out.println("proveïdors: " + m.getEstocProveidors());
				
		// produeix pintura magenta, que falta per les comandes, i torna a processar
		
		pMagenta.produirPintura(50);
		
		System.out.println("\n===> PRODUCCIÓ magenta 50");
		System.out.println("proveïdors: " + m.getEstocProveidors());
		
		fetes = m.processarComandes();
		
		System.out.println("\n===> PROCESSAMENT");
		
		System.out.println("fetes: " + fetes);		
		System.out.println("pendents: " + m.getComandesPendents());
		System.out.println("magatzem: " + m.getEstocMagatzem());
		System.out.println("proveïdors: " + m.getEstocProveidors());

	}
}
