import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement (name = "gato")
public class Gatete {
	
	String nom;
	int edat;
	double longitud;
	String sexo;
	ArrayList<Vacuna> vacunas;
	
	
	public Gatete() {
		super();
	}
	
	

	public Gatete(String nom, int edat, double longitud, String sexo, ArrayList<Vacuna> vacunas) {
		super();
		this.nom = nom;
		this.edat = edat;
		this.longitud = longitud;
		this.sexo = sexo;
		this.vacunas = vacunas;
	}



	@XmlElementWrapper(name="vacunas")
	@XmlElement(name="vacuna")
	public ArrayList<Vacuna> getVacunas() {
		return vacunas;
	}



	public void setVacunas(ArrayList<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}



	@XmlElement
	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	@XmlElement
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlElement
	public int getEdat() {
		return edat;
	}


	public void setEdat(int edat) {
		this.edat = edat;
	}

	@XmlElement
	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}



	@Override
	public String toString() {
		return "Gatete [nom=" + nom + ", edat=" + edat + ", longitud=" + longitud + ", sexo=" + sexo + ", vacunas="
				+ vacunas + "]";
	}


	
	
	
	
	
	
	
	
	

}
