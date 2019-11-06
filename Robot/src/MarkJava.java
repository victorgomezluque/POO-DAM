
public class MarkJava {
	
	int energia =10;
	boolean mov;
	int nomAtleatori;
	

	public int obteEnergia(int energia) {
		return energia;
	}
	
	public boolean decideixSiMou() {
		return false;
	}
	
	public void gastaEnergia(int energia) {
		//aquest mètode resta l'energiaGastada de l'energia del robot. Si
		//l'energia queda menor que 0 s'ha de llançar una excepció de tipus
		//IllegalArgumentException. Això no hauria de passar mai, si passa significa
		//que hi ha un error en el programa. Sempre que un robot gasti energia ho farà
		//cridant a aquest mètode.
	}
	
	void gastaBateria() {
		energia = 0;
	}
	
	
	void interactua (MarkJava unAltreRobot) {
		//aquest mètode defineix què passa
		//quan aquest robot en troba un altre, però cada tipus fa coses diferents.
	}
	
	public void recargarBateria() {
		energia=10;
	}

}
