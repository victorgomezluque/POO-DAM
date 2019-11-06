
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "institut")
@XmlType(propOrder= {"nom","alumnes", "professors"})
public class Institut {
	
	String nom;
	ArrayList<Alumne> alumnes = new ArrayList<Alumne>();
	ArrayList<Professor> professors = new ArrayList<Professor>();
	
	@XmlElementWrapper(name = "professors")
    @XmlElement(name = "professor")
	public ArrayList<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}
	
	@Override
	public String toString() {
		return "Institut [nom=" + nom + ", alumnes=" + alumnes + ", professors=" + professors + "]";
	}

	public Institut() {
		super();
	}

	@XmlElement
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlElementWrapper(name = "alumnes")
    @XmlElement(name = "alumne")
	public ArrayList<Alumne> getAlumnes() {
		return alumnes;
	}

	public void setAlumnes(ArrayList<Alumne> alumnes) {
		this.alumnes = alumnes;
	}
	
	
	
}
