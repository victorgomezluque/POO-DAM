package problemes.pintures.impl;

import problemes.pintures.Color;
import problemes.pintures.ProveidorPintura;

public class ProveidorPinturaImpl implements ProveidorPintura {
	
	public ProveidorPinturaImpl(Color color, int estoc, int comandaMinima) {
	}

	@Override
	public Color getColor() {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public int getEstoc() {
		throw new RuntimeException("no implementat!");
	}
	
	@Override
	public int getQuantitatMinima() {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public void produirPintura(int quantitat) {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public int retirarPintura(int quantitat) {
		throw new RuntimeException("no implementat!");
	}

}
