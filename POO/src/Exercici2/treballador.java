package Exercici2;

public abstract class treballador extends Persona {

	private String numSS;
	private String adrešatreball;
	

	treballador(String numSS,String adrešatreball,String adreša,String nom){
		super(nom,adreša);
		this.adrešatreball=adrešatreball;
		this.numSS=numSS;
	}


	public String getNumSS() {
		return numSS;
	}


	public void setNumSS(String numSS) {
		this.numSS = numSS;
	}


	public String getAdrešatreball() {
		return adrešatreball;
	}


	public void setAdrešatreball(String adrešatreball) {
		this.adrešatreball = adrešatreball;
	}
	
	public void obtenirdades(String adrešaTreball,String adreša) {
		System.out.println("Adreša del treball" + adrešaTreball);
		System.out.println("Adreša del treballador" + adreša);
	}

}
