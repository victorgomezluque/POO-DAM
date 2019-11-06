package Exercici2;

public class professor extends treballador{

	private String titulacio;
	private String especialitat;
	
	professor(String titulacio,String especialitat,String adreça,String nom,String numSS,String adreçatreball){
	super(nom,adreça,numSS,adreçatreball);
	this.especialitat=especialitat;
	this.titulacio=titulacio;

		
	}

	public String getTitulacio() {
		return titulacio;
	}

	public String getEspecialitat() {
		return especialitat;
	}
	
}
