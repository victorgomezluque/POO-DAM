import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.*;

@XmlRootElement(name="Protectoras")
public class Protectoras {
	
	ArrayList<Gatete> gatetes;
	String nombre;
	String direccion;
	
	public Protectoras() {
		super();
	}
	
	
	public Protectoras(ArrayList<Gatete> gatetes, String nombre, String direccion) {
		super();
		this.gatetes = gatetes;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@XmlElementWrapper(name="gatetes")
	@XmlElement(name="gato")
	public ArrayList<Gatete> getGatetes() {
		return gatetes;
	}

	public void setGatetes(ArrayList<Gatete> gatetes) {
		this.gatetes= gatetes;
	}

	@Override
	public String toString() {
		return "Protectoras [gatetes=" + gatetes + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	

}
