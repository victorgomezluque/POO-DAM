package problemes.sorteig;

import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 * Has d'implementar una classe SorteigImpl que permet sortejar premis entre concursants.
 * 
 * Els concursants arriben i aconsegueixen un bolet, i entren a una cua.
 * Els bolets poden estar repetits, i només aconsegueix el premi qui està abans a la cua.
 * De tant en tant (1/4), la cua s'inverteix, i l'últims seran els primers.
 * 
 * Tenim dues interfícies que permeten generar els bolets i els premis:
 * 
 * V GeneradorBolets.genera(K clau) => genera un bolet V per a un concursant identificat amb K
 * V GeneradorPremis.genera() => genera un bolet premiat V
 * 
 * La interfície Sorteig permet fer les següents operacions:
 * 
 * V afegir(K clau) => afegeix un nou concursant a la cua
 * void invertir() => inverteix la cua de concursants utilitzant una pila
 * Queue<K> concursants() => retorna la cua de concursants
 * Set<K> sortejar() => fa el sorteig i retorna els identificadors dels guanyadors
 * Map<V, Boolean> premiats() => retorna un mapa amb cada bolet guanyador i si s'ha trobat un guanyador
 * 
 * Aquesta classe utilitza els generadors amb uns tipus concrets: 
 * K és un DNI (String)
 * V és un sencer, l'última xifra del DNI.
 * 
 * Aquesta és una possible sortida del programa:
 * 
nombre de premis/participants: 10/20
77105787K participa amb 7
11114721Q participa amb 1
26534691Z participa amb 1
34651293T participa amb 3
62920030F participa amb 0
86188837Q participa amb 7
60148692E participa amb 2
15947206O participa amb 6
71800374T participa amb 4
43133448T participa amb 8
39092012P participa amb 2
79055913P participa amb 3
50538577Z participa amb 7
51778398A participa amb 8
31209029X participa amb 9
36046391D participa amb 1
42614496X participa amb 6
24249120E participa amb 0
9347971M participa amb 1
31516931A participa amb 1
concursants: [77105787K, 11114721Q, 26534691Z, 34651293T, 62920030F, 86188837Q, 60148692E, 15947206O, 71800374T, 43133448T, 39092012P, 79055913P, 50538577Z, 51778398A, 31209029X, 36046391D, 42614496X, 24249120E, 9347971M, 31516931A]
invertint la llista
invertits: [31516931A, 9347971M, 24249120E, 42614496X, 36046391D, 31209029X, 51778398A, 50538577Z, 79055913P, 39092012P, 43133448T, 71800374T, 15947206O, 60148692E, 86188837Q, 62920030F, 34651293T, 26534691Z, 11114721Q, 77105787K]
guanyadors: [31516931A, 24249120E, 42614496X, 50538577Z, 51778398A, 39092012P, 31209029X, 79055913P, 71800374T]
bolets: {0=true, 1=true, 2=true, 3=true, 4=true, 5=false, 6=true, 7=true, 8=true, 9=true}
 *
 */
public class ProvaSorteig {
	
	public static void main(String[] args) {
		
		test(10, 20);
	}

	public static void test(int numPremis, int numConcursants) {

		System.out.println("nombre de premis/participants: " + numPremis + "/" + numConcursants);
		
		Random r = new Random();

//		GeneradorPremis<Integer> genpremis = new GeneradorPremisImpl();
		GeneradorPremis<Integer> genpremis = new GeneradorPremis<Integer>() {

			@Override
			public Integer genera() {
				return r.nextInt(10);
			}
		};

		GeneradorBolets<String, Integer> genbolets = new GeneradorBolets<String, Integer>() {

			@Override
			public Integer genera(String clau) {

				int dni = Integer.parseInt(clau.substring(0, clau.length() - 1));
				return dni % 10;
			}
		};
		
		Sorteig<String, Integer> s = new SorteigImpl<>(numPremis, genpremis, genbolets);

		for (int i = 0; i < numConcursants; i++) {
			char c = (char) (r.nextInt(26) + 'A');
			String dni = Integer.toString(r.nextInt(100000000) + 1000000) + c;
			int bolet = s.afegir(dni);
			System.out.println(dni + " participa amb " + bolet);
		}

		System.out.println("concursants: " + s.concursants());

		// 1 possibilitat entre 4 d'invertir la llista (els ultims seran els primers)
		if (r.nextInt(4) == 0) {
			System.out.println("invertint la llista");
			s.invertir();
			System.out.println("invertits: " + s.concursants());
		}

		Set<String> resultat = s.sortejar();
		System.out.println("guanyadors: " + resultat);

		Map<Integer, Boolean> bolets = s.premiats();
		System.out.println("bolets: " + bolets);
	}
}
