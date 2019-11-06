package problemes.sorteig;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class SorteigImpl<K, V> implements Sorteig<K, V> {
	private GeneradorBolets<K, V> genbolets;
	private Map<K, V> map = new HashMap<K, V>();
	Set<K> ganadores = new HashSet();
	private Set<Integer> num = new HashSet();
	GeneradorPremis<V> genpremis;
	int numPremis = 10;
	final Map numerosPremiados = new HashMap<K, Boolean>();

	Queue<K> cola = new ArrayDeque();

	public SorteigImpl(int numPremis, GeneradorPremis<V> genpremis, GeneradorBolets<K, V> genbolets) {
		this.genbolets = genbolets;
	}

	@Override
	public V afegir(K clau) {
		V valor = genbolets.genera(clau);

		cola.add(clau);
		map.put(clau, valor);
		return valor;
	}

	@Override
	public void invertir() {
		Stack<K> colaInvert = new Stack();
		while (!this.cola.isEmpty()) {
			colaInvert.push(this.cola.remove());
		}
		while (!colaInvert.isEmpty()) {
			this.cola.add(colaInvert.pop());
		}
	}

	@Override
	public Queue<K> concursants() {
		return cola;
	}

	@Override
	public Set<K> sortejar() {
		Random rnd = new Random();
		int i = 0;

		for (int j = 0; j < numPremis; j++) {
			i = rnd.nextInt(10);
			num.add(i);
			for (Iterator iterator = cola.iterator(); iterator.hasNext();) {
				K k = (K) iterator.next();
				V bolet = map.get(k);
				if (map.get(k).equals(i)) {
					ganadores.add(k);
					numerosPremiados.put(bolet, false);
				}else {
					numerosPremiados.put(bolet, true);
				}
			}

			
		}
		

		return ganadores;

	}

	@Override
	public Map<V, Boolean> premiats() {
	
		return numerosPremiados;

	}

}
