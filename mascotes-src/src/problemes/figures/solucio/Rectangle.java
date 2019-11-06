package problemes.figures.solucio;

import problemes.figures.problema.Llenc;

public class Rectangle extends FiguraColorImpl {

	private double amplada, altura;
	
	public Rectangle(double amplada, double altura) {
		this.amplada = amplada;
		this.altura = altura;
	}
	
	@Override
	public void dibuixa(Llenc llenc) {
		llenc.setColor(getColor()); 
		llenc.dibuixaRectangle(getPosicio().x, getPosicio().y, amplada, altura);
	}

}
