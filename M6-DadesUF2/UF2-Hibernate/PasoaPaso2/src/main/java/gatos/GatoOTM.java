package gatos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gatoOTM")
public class GatoOTM {
	

	//Tabla de Gatos
	//id AUTONUMERICO PK
	//nombre VARCHAR
	//capado booleano
	//edad int
	//raza VARCHAR
	//fecha de nacimiento DATE
	
	
	@Id
	@Column(name = "id")
	private int id;
	
	

	@Column(name = "nombre")
	String nombre;
	
	@Column(name = "capado")
	boolean capado;
	
	@Column(name = "edad")
	int edad;
	
	@Column(name = "raza")
	String raza;
	
	@Column(name = "fecha_nacimiento")
	Date fecha;
	
	//oneToMany. ahi decimos de que queremos el set (que tabla) y dentro de esa tabla cual es la variable que contiene
	//la llave foranea, es decir, el gato. Cuidado con las mayusculas, no seas imbecil como yo
	@OneToMany(mappedBy="gatoOTM")
	Set<Caixa> caixa;

	
	public GatoOTM(int id, String nombre, boolean capado, int edad, String raza, Date fecha, Set<Caixa> caixa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capado = capado;
		this.edad = edad;
		this.raza = raza;
		this.fecha = fecha;
		this.caixa = caixa;
	}
	
	public GatoOTM() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isCapado() {
		return capado;
	}

	public void setCapado(boolean capado) {
		this.capado = capado;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Set<Caixa> getCaixa() {
		return caixa;
	}

	public void setCaixa(Set<Caixa> caixa) {
		this.caixa = caixa;
	}


	
	

}
