package conrelaciones;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

//si solo vamos a usar el enum en una clase podemos crearlo como enum dentro del fichero (pero no dentro de la clase)
//un fichero puede tener infinitas clases, pero solo una public class
enum CicloFormativo {
	DAM,
	ASIX,
	DAMVI
}

@Entity
@Table(name = "curso")
public class Curso {
	
	
	@Id
    //Eso indica que es un autonum�rico.
    //Hay varias estrategias de generacion
    //Identity: Mas eficiente a nivel BD
    //Sequence: Mas eficiente a nivel Hibernate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	//type, especifica el tipo. 
	//SQL no tiene booleanos. As� que puedes usar numeric_boolean (0 false, 1 true)
	//tambien puedes usar true_false ('F' false, 'T' true) o yes_no ('N' false, 'Y' true)
	@Type(type="numeric_boolean")
	@Column(name = "activo")
	boolean activo;
	
	//especificas que el ano no puede ser null
	@Column(name = "ano", nullable=false)
	int ano;
	
	//Enumerated indica que vas a usar un enum para representarlo.
	//ordinal, pone 0,1,2 a los enums en la BD. String pone el nombre mismo como un varchar
	@Enumerated(EnumType.STRING)
	@Column(name = "ciclo")
	CicloFormativo ciclo;

	
	//oneToMany. ahi decimos de que queremos el set (que tabla) y dentro de esa tabla cual es la columna que contiene
	//la llave foranea, es decir, el curso. Cuidado con las mayusculas, no seas imbecil como yo
	@OneToMany(mappedBy="curso")
	Set<Modulo> modulos = new HashSet<Modulo>();
	
	//OneToOne, simplemente pones el objeto al que referencias
	@JoinColumn(name="tutor", nullable=false)
	@OneToOne(cascade = CascadeType.PERSIST)
   private Profesor tutor;


	public Curso() {
		super();
	}
	public Curso(boolean activo, int curso, CicloFormativo ciclo) {
		super();
		this.activo = activo;
		this.ano = curso;
		this.ciclo = ciclo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public int getCurso() {
		return ano;
	}


	public void setCurso(int curso) {
		this.ano = curso;
	}


	public CicloFormativo getCiclo() {
		return ciclo;
	}


	public void setCiclo(CicloFormativo ciclo) {
		this.ciclo = ciclo;
	}


	public Set<Modulo> getModulos() {
		return modulos;
	}


	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}
	

	public Profesor getTutor() {
		return tutor;
	}


	public void setTutor(Profesor tutor) {
		this.tutor = tutor;
	}


	@Override
	public int hashCode() {
		//se usa un numero primo como sal del hash
		final int prime = 31;
		//cada clase debe tener un result distinto
		int result = 23435;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Curso))
			return false;
		Curso other = (Curso) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
