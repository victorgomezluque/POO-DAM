package Exercici2;

public class professor extends treballador{

	private String titulacio;
	private String especialitat;
	
	professor(String titulacio,String especialitat,String adreša,String nom,String numSS,String adrešatreball){
	super(nom,adreša,numSS,adrešatreball);
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
