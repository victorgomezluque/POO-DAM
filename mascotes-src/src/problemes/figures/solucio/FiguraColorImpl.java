package problemes.figures.solucio;

import problemes.figures.problema.Color;
import problemes.figures.problema.Llenc;
import problemes.figures.problema.TeColor;

public abstract class FiguraColorImpl extends FiguraImpl implements TeColor {

	private Color color;
	
	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}

}
