package problemes.figures.test;

import problemes.figures.problema.Color;
import problemes.figures.problema.Llenc;
import problemes.figures.problema.Punt;
import problemes.figures.solucio.LlencImpl;
import problemes.figures.solucio.Quadrat;
import problemes.figures.solucio.Rectangle;

public class ProvaFigures {

	public static void main(String[] args) {
		
		Llenc llenc = new LlencImpl();
		
		Punt centre = new Punt(50, 50);
		
		Rectangle r = new Rectangle(45, 30);
		r.setPosicio(centre);
		r.setColor(Color.RED);		
		r.dibuixa(llenc);
		
		/*
		Ellipse e = new Ellipse(45, 30);
		e.setPosicio(centre);
		e.setColor(Color.BLUE);		
		e.dibuixa(llenc);
		
		Cercle c = new Cercle(25);
		c.setPosicio(centre);
		c.setColor(Color.YELLOW);		
		c.dibuixa(llenc);
		*/
		
		Quadrat q = new Quadrat(15);
		q.setPosicio(centre);
		q.setColor(Color.GREEN);		
		q.dibuixa(llenc);
	}
}
