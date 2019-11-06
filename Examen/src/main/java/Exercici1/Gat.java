package Exercici1;

public class Gat {
	String nom;
	String raza;
	int edat;
	String menjatPreferit;
	Boolean capat;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public String getMenjatPreferit() {
		return menjatPreferit;
	}
	public void setMenjatPreferit(String menjatPreferit) {
		this.menjatPreferit = menjatPreferit;
	}
	public Boolean getCapat() {
		return capat;
	}
	public void setCapat(Boolean capat) {
		this.capat = capat;
	}
	public Gat(String nom, String raza, int edat, String menjatPreferit, Boolean capat) {
		super();
		this.nom = nom;
		this.raza = raza;
		this.edat = edat;
		this.menjatPreferit = menjatPreferit;
		this.capat = capat;
	}
	@Override
	public String toString() {
		return "Gat [nom=" + nom + ", raza=" + raza + ", edat=" + edat + ", menjatPreferit=" + menjatPreferit
				+ ", capat=" + capat + "]";
	}
	
	
	
}
