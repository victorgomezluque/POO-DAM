package Exercici2;

public class intercanvi extends estudiant {

	private String paisOrigen;

	intercanvi(String dataAlta,String edat,String nif, String paisOrigen,String nom,String adre�a){
		super(dataAlta,edat,nif, nom,adre�a);
		this.paisOrigen=paisOrigen;
		
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}
	
	void mostrar() {
		System.out.println(paisOrigen);
	}

}
