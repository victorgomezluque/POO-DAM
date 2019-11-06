package pintures.impl;

import pintures.Color;
import pintures.ProveidorPintura;

public class ProveidorPinturaImpl implements ProveidorPintura {
	int estoc;
	Color color;
	int quantitatMinima;

	public ProveidorPinturaImpl(Color color, int estoc, int comandaMinima) {
		this.color = color;

		this.quantitatMinima = comandaMinima;

		this.estoc = estoc;
	}

	@Override
	public Color getColor() {

		return this.color;
	}

	@Override
	public int getEstoc() {
		return this.estoc;
	}

	@Override
	public int getQuantitatMinima() {
		return this.quantitatMinima;
	}

	@Override
	public void produirPintura(int quantitat) {

		estoc = estoc + quantitat;

	}

	@Override
	public int retirarPintura(int quantitat) {
		if (quantitat < estoc) {
			if (quantitat >= quantitatMinima) {
				estoc = estoc - quantitat;
				return quantitat;
			} else if (quantitat < quantitatMinima) {
				estoc = estoc - quantitatMinima;
				return quantitatMinima;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
}
