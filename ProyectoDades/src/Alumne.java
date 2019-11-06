
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "alumne")
@XmlType(propOrder= {"nom","cognoms","dni","adreca","telefons","mail"})
public class Alumne {

	String nom;
	String cognoms;
	String dni;
	String adreca;
	ArrayList<String> telefons = new ArrayList<String>();
	String mail;
	
	public Alumne() {
		super();
	}

	public Alumne(String nom, String cognoms, String dni, String adreca, ArrayList<String> telefons, String mail) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
		this.adreca = adreca;
		this.telefons = telefons;
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Alumne [nom=" + nom + ", cognoms=" + cognoms + ", dni=" + dni + ", adreca=" + adreca + ", telefons="
				+ telefons + ", mail=" + mail + "]";
	}

	@XmlElement
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlElement
	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	@XmlElement(name="DNI")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@XmlElement
	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	@XmlElementWrapper(name = "telefons")
    @XmlElement(name = "telefon")
	public ArrayList<String> getTelefons() {
		return telefons;
	}

	public void setTelefons(ArrayList<String> telefons) {
		this.telefons = telefons;
	}

	@XmlElement
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
