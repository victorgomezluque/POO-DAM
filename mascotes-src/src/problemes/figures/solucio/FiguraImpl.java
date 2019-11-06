package problemes.figures.solucio;

import problemes.figures.problema.Figura;
import problemes.figures.problema.Llenc;
import problemes.figures.problema.Punt;

public abstract class FiguraImpl implements Figura {

	private Punt posicio;
	
	@Override
	public Punt getPosicio() {
		return posicio;
	}

	@Override
	public void setPosicio(Punt posicio) {
		this.posicio = posicio;
	}
}
