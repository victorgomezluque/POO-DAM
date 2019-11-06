import java.util.Random;

public class Mecanic extends MarkJava {

	int energia = 10;
	boolean mov;
	int nomAtleatori;

	void interactua(MarkJava unAltreRobot) {
		if (energia < 4) {
			recargarBateria();
		}
	}

	public boolean decideixSiMou() {
		if (energia < 5) {
			recargarBateria();
		} else {
			Random rnd = new Random(10);
			int i = rnd.nextInt();
			if(i>6) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	

}
