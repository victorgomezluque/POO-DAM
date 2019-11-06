package Exercici2;

public abstract class treballador extends Persona {

	private String numSS;
	private String adreçatreball;
	

	treballador(String numSS,String adreçatreball,String adreça,String nom){
		super(nom,adreça);
		this.adreçatreball=adreçatreball;
		this.numSS=numSS;
	}


	public String getNumSS() {
		return numSS;
	}


	public void setNumSS(String numSS) {
		this.numSS = numSS;
	}


	public String getAdreçatreball() {
		return adreçatreball;
	}


	public void setAdreçatreball(String adreçatreball) {
		this.adreçatreball = adreçatreball;
	}
	
	public void obtenirdades(String adreçaTreball,String adreça) {
		System.out.println("Adreça del treball" + adreçaTreball);
		System.out.println("Adreça del treballador" + adreça);
	}

}
