package Exercici2;

public class PersonalGestio extends treballador {

	private String posicio;

	PersonalGestio(String adre�a,String nom,String numSS,String adre�atreball,String posicio) {
		super(nom,adre�a,numSS,adre�atreball);
		this.posicio=posicio;
	}
	public String getPosicio() {
		return posicio;
	}
	public void setPosicio(String posicio) {
		this.posicio = posicio;
	}

}
