package problemes.parells.test;

import java.util.ArrayList;
import java.util.List;

import problemes.parells.Parell;
import problemes.parells.ParellFactory;
import problemes.parells.ParellIgual;
import problemes.parells.ProcessadorParells;
import problemes.parells.impl.ParellFactoryImpl;

public class ParellsTest {
	
	/* sortida esperada (l'ordre no és important):
	====> coorProc 1
	collection: [1:1, 1:2, 2:1, 2:2]
	set: [2:1, 1:1, 2:2, 1:2]
	esquerres: [1, 2]
	dretes: [1, 2]
	compte esquerres: {1=2, 2=2}
	compte dretes: {1=2, 2=2}
	
	====> coorProc 2
	collection: [1:1, 1:2, 2:1, 2:2, 0:3, 1:1]
	set: [2:1, 1:1, 2:2, 1:2, 0:3]
	esquerres: [0, 1, 2]
	dretes: [1, 2, 3]
	compte esquerres: {0=1, 1=3, 2=2}
	compte dretes: {1=3, 2=2, 3=1}
	
	====> nomProc
	collection: [Mary:Smith, Peter:Frampton, Ronnie:Smith, Mary:Brown]
	set: [Ronnie:Smith, Mary:Smith, Peter:Frampton, Mary:Brown]
	esquerres: [Ronnie, Peter, Mary]
	dretes: [Brown, Smith, Frampton]
	compte esquerres: {Ronnie=1, Peter=1, Mary=2}
	compte dretes: {Brown=1, Smith=2, Frampton=1}
  	*/
	
	public static void main(String[] args) {
		
		testFactory(new ParellFactoryImpl());
	}

	public static void testFactory(ParellFactory factory) {
		
		List<ParellIgual<Integer>> coords = new ArrayList<>();
		coords.add(factory.creaParellIgual(1, 1));
		coords.add(factory.creaParellIgual(1, 2));
		coords.add(factory.creaParellIgual(2, 1));
		coords.add(factory.creaParellIgual(2, 2));		
		
		ProcessadorParells<Integer, Integer, ParellIgual<Integer>> coorProc = factory.creaProcessador(coords);
		
		System.out.println("\n====> coorProc 1");
		mostraProcessador(coorProc);
		
		coords.add(factory.creaParellIgual(0, 3));
		coords.add(factory.creaParellIgual(1, 1));
		
		System.out.println("\n====> coorProc 2");
		mostraProcessador(coorProc);
						
		List<Parell<String, String>> noms = new ArrayList<>();
		noms.add(factory.creaParell("Mary", "Smith"));
		noms.add(factory.creaParell("Peter", "Frampton"));
		noms.add(factory.creaParell("Ronnie", "Smith"));
		noms.add(factory.creaParell("Mary", "Brown"));
		
		ProcessadorParells<String, String, Parell<String, String>> nomProc = factory.creaProcessador(noms);
		
		System.out.println("\n====> nomProc");
		mostraProcessador(nomProc);
	}
	
	static <L, R, T extends Parell<L, R>> void mostraProcessador(ProcessadorParells<L, R, T> proc) {
		
		System.out.println("collection: " + proc.getCollection());
		System.out.println("set: " + proc.getSet());
		System.out.println("esquerres: " + proc.getEsquerres());
		System.out.println("dretes: " + proc.getDretes());
		System.out.println("compte esquerres: " + proc.comptaEsquerres());
		System.out.println("compte dretes: " + proc.comptaDretes());
	}
}
