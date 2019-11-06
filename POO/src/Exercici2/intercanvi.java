package Exercici2;

public class intercanvi extends estudiant {

	private String paisOrigen;

	intercanvi(String dataAlta,String edat,String nif, String paisOrigen,String nom,String adreça){
		super(dataAlta,edat,nif, nom,adreça);
		this.paisOrigen=paisOrigen;
		
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}
	
	void mostrar() {
		System.out.println(paisOrigen);
	}

}
