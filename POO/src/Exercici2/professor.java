package Exercici2;

public class professor extends treballador{

	private String titulacio;
	private String especialitat;
	
	professor(String titulacio,String especialitat,String adre�a,String nom,String numSS,String adre�atreball){
	super(nom,adre�a,numSS,adre�atreball);
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
