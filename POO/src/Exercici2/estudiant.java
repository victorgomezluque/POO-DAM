package Exercici2;

public abstract class estudiant extends Persona {

	private String dataAlta;
	private String edat;
	private String nif;

	
	estudiant(String dataAlta,String edat,String nif,String nom,String adre�a){
		super(nom,adre�a);
		this.dataAlta=dataAlta;
		this.edat=edat;
		this.nif=nif;
	}


	public String getDataAlta() {
		return dataAlta;
	}


	public String getEdat() {
		return edat;
	}


	public String getNif() {
		return nif;
	}
	
	

}
