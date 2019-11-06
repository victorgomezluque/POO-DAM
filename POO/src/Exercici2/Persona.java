package Exercici2;

public abstract class Persona {
	private String nom;
	private String adreça;
	
	public Persona(String nom,String adreça){
		this.nom=nom;
		this.adreça=adreça;
	}

	public String getNom() {
		return nom;
	}

	public String getAdreça() {
		return adreça;
	}
	
	
	
}
