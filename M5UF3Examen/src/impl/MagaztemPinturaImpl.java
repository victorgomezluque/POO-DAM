package impl;


import java.util.List;
import java.util.Map;
import java.util.Queue;

import impl.pintures.Color;
import impl.pintures.Comanda;
import impl.pintures.MagatzemPintura;
import impl.pintures.ProveidorPintura;

public class MagatzemPinturaImpl implements MagatzemPintura {

	public MagatzemPinturaImpl() {
	}

	@Override
	public void afegirProveidor(ProveidorPintura proveidor) {		
		throw new RuntimeException("no implementat!");
	}
	
	@Override
	public ProveidorPintura getProveidor(Color color) {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public Map<Color, Integer> getEstocMagatzem() {
		throw new RuntimeException("no implementat!");
	}	
	
	public Map<Color, Integer> getEstocProveidors() {		
		throw new RuntimeException("no implementat!");
	}
	
	@Override
	public void afegirComanda(Comanda comanda) {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public List<Comanda> processarComandes() {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public Queue<Comanda> getComandesPendents() {
		throw new RuntimeException("no implementat!");
	}

}
