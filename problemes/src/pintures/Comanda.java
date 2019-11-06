package pintures;


public class Comanda {
	
	private int quantitat;
	private Color color;

	public Comanda(Color color, int quantitat) {
		this.color = color;
		this.quantitat = quantitat;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Comanda [quantitat=" + quantitat + ", color=" + color + "]";
	}
}
