package pintures.impl;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import pintures.Color;
import pintures.Comanda;
import pintures.MagatzemPintura;
import pintures.ProveidorPintura;

public class MagatzemPinturaImpl implements MagatzemPintura {
	private Map<Color, Integer> estoc;
	private Queue<Comanda> comandes;
	private Map<Color, ProveidorPintura> proveidors;
	private Map<Color, Integer> proveidors1;

	public MagatzemPinturaImpl() {

		this.estoc = new HashMap<Color, Integer>();
		this.proveidors = new HashMap<Color, ProveidorPintura>();
		this.comandes = new ArrayDeque<Comanda>();
		this.proveidors1 = new HashMap<Color, Integer>();
	}

	@Override
	public void afegirProveidor(ProveidorPintura proveidor) {
		proveidors.put(proveidor.getColor(), proveidor);
		estoc.put(proveidor.getColor(), 0);
	}

	@Override
	public ProveidorPintura getProveidor(Color color) {
		return proveidors.get(color);
	}

	@Override
	public Map<Color, Integer> getEstocMagatzem() {
		return estoc;
	}

	public Map<Color, Integer> getEstocProveidors() {

		for (Entry<Color, ProveidorPintura> p : proveidors.entrySet()) {
			proveidors1.put(p.getKey(), p.getValue().getEstoc());
		}

		return proveidors1;

	}

	@Override
	public void afegirComanda(Comanda comanda) {
		comandes.add(comanda);
	}

	@Override
	public List<Comanda> processarComandes() {
		ArrayList<Comanda> processament = new ArrayList<Comanda>();
		
		for (Iterator iterator = comandes.iterator(); iterator.hasNext();) {
			Comanda comanda = (Comanda) iterator.next();
				if(comanda.getQuantitat()<estoc.get(comanda.getColor())) {
					processament.add(comanda);
					comandes.remove(comanda);
					
				}
					
			

		}
		return processament;
	}

	@Override
	public Queue<Comanda> getComandesPendents() {
		return comandes;
	}

}
