
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vacuna")
public class Vacuna {
	
	String nom;
	String fecha;
	int validez;
	
	public Vacuna() {
		super();
	}
	
	public Vacuna(String nom, String fecha, int validez) {
		super();
		this.nom = nom;
		this.fecha = fecha;
		this.validez = validez;
	}

	@XmlElement
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElement
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@XmlElement
	public int getValidez() {
		return validez;
	}
	public void setValidez(int validez) {
		this.validez = validez;
	}

	@Override
	public String toString() {
		return "Vacuna [nom=" + nom + ", fecha=" + fecha + ", validez=" + validez + "]";
	}
	
	
	
	

}
