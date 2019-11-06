package projecteFitxersXML;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder= {"nom","cognom"})
public class Professor implements Serializable {

	private String nom;
	private String cognom;
	
	@XmlElement
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Professor(String nom, String cognom) {
		super();
		this.nom = nom;
		this.cognom = cognom;
	}
	
	@XmlElement
	public String getCognom() {
		return cognom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	
	public Professor() {
		super();
	}
	
	@Override
	public String toString() {
		return "Professor [nom=" + nom + ", cognom=" + cognom + "]\n";
	}

}
