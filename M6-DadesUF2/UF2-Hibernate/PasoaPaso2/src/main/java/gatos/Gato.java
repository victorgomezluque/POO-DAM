package gatos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gato")
public class Gato {
	

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
	
	
	

}
