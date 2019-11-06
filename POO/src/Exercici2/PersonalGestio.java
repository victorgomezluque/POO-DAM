package Exercici2;

public class PersonalGestio extends treballador {

	private String posicio;

	PersonalGestio(String adreça,String nom,String numSS,String adreçatreball,String posicio) {
		super(nom,adreça,numSS,adreçatreball);
		this.posicio=posicio;
	}
	public String getPosicio() {
		return posicio;
	}
	public void setPosicio(String posicio) {
		this.posicio = posicio;
	}

}
