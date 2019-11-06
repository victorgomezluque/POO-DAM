package problemes.figures.problema;

public interface Llenc {

	double getAmplada();
	
	double getAltura();
	
	void setColor(Color color);
	
	void dibuixaEllipse(double x, double y, double amplada, double altura);
	
	void dibuixaRectangle(double x, double y, double amplada, double altura);
}
