package Exercici2;

public class PersonalGestio extends treballador {

	private String posicio;

	PersonalGestio(String adreša,String nom,String numSS,String adrešatreball,String posicio) {
		super(nom,adreša,numSS,adrešatreball);
		this.posicio=posicio;
	}
	public String getPosicio() {
		return posicio;
	}
	public void setPosicio(String posicio) {
		this.posicio = posicio;
	}

}
