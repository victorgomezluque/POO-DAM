package Exercici2;

public abstract class treballador extends Persona {

	private String numSS;
	private String adre�atreball;
	

	treballador(String numSS,String adre�atreball,String adre�a,String nom){
		super(nom,adre�a);
		this.adre�atreball=adre�atreball;
		this.numSS=numSS;
	}


	public String getNumSS() {
		return numSS;
	}


	public void setNumSS(String numSS) {
		this.numSS = numSS;
	}


	public String getAdre�atreball() {
		return adre�atreball;
	}


	public void setAdre�atreball(String adre�atreball) {
		this.adre�atreball = adre�atreball;
	}
	
	public void obtenirdades(String adre�aTreball,String adre�a) {
		System.out.println("Adre�a del treball" + adre�aTreball);
		System.out.println("Adre�a del treballador" + adre�a);
	}

}
