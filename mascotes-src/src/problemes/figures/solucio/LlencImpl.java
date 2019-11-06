package problemes.figures.solucio;

import problemes.figures.llibreria.StdDraw;
import problemes.figures.problema.Color;
import problemes.figures.problema.Llenc;

public class LlencImpl implements Llenc {
	
	private static final int MIDA = 700;
	private static final int RANG = 100;
	
	public LlencImpl() {
		StdDraw.setCanvasSize(MIDA, MIDA);
		StdDraw.setScale(0, RANG);
	}

	@Override
	public double getAmplada() {
		return RANG;
	}
	
	@Override
	public double getAltura() {
		return RANG;
	}
	
	@Override
	public void setColor(Color color) {
		
		java.awt.Color jac = null;
		
		switch (color) {
		case BLACK:
			jac = java.awt.Color.BLACK; break;
		case BLUE:
			jac = java.awt.Color.BLUE; break;
		case CYAN:
			jac = java.awt.Color.CYAN; break;
		case DARK_GRAY:
			jac = java.awt.Color.DARK_GRAY; break;
		case GRAY:
			jac = java.awt.Color.GRAY; break;
		case GREEN:
			jac = java.awt.Color.GREEN; break;
		case LIGHT_GRAY:
			jac = java.awt.Color.LIGHT_GRAY; break;
		case MAGENTA:
			jac = java.awt.Color.MAGENTA; break;
		case ORANGE:
			jac = java.awt.Color.ORANGE; break;
		case PINK:
			jac = java.awt.Color.PINK; break;
		case RED:
			jac = java.awt.Color.RED; break;
		case WHITE:
			jac = java.awt.Color.WHITE; break;
		case YELLOW:
			jac = java.awt.Color.YELLOW; break;
		}
		
		StdDraw.setPenColor(jac);
	}

	@Override
	public void dibuixaEllipse(double x, double y, double amplada, double altura) {
		
		StdDraw.filledEllipse(x, y, amplada/2, altura/2);
	}

	@Override
	public void dibuixaRectangle(double x, double y, double amplada, double altura) {
		
		StdDraw.filledRectangle(x, y, amplada/2, altura/2);
	}

}
