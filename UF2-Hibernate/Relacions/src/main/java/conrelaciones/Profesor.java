package conrelaciones;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="Profesor")
public class Profesor implements Serializable  {
    
	//llave primaria
    @Id
    //Eso indica que es un autonumérico.
    //Hay varias estrategias de generacion
    //Identity: Mas eficiente a nivel BD
    //Sequence: Mas eficiente a nivel Hibernate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //no se puede updatear ni poner null
    @Column(name="Id",updatable = false, nullable = false)
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    //columnDefinition. Pones lo que pondrias en SQL
    @Column(name="ape1", columnDefinition="VARCHAR(100) not null")
    private String ape1;
    
    @Column(name="ape2")    
    private String ape2;
    
    
    @Column(name="horas_asignadas")    
    private int horasAsignadas;
    
    //Relacion Many to Many
    @ManyToMany(cascade = {CascadeType.REFRESH})
    //Declaras la tabla de Join intermedia
    //Clave:  @JoinTable(name="nombreDeLaTablaIntermedia", joinColumns={@JoinColumn(name="LlavePrimariaThisEnTablaIntermedia")}, inverseJoinColumns={@JoinColumn(name="LlavePrimariaOtraClaseEnTablaIntermedia")})
    @JoinTable(name="ProfesorModulo", joinColumns={@JoinColumn(name="IdProfesor")}, inverseJoinColumns={@JoinColumn(name="IdModulo")})
    //La Many to Many se declara mediante un doble HashSet
    private Set<Modulo> modulos=new HashSet();
    

    public Profesor(){ 
    }

    public Profesor(String nombre, String ape1, String ape2) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
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

    public String getApe1() {
        return ape1;
    }
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
    
    

	public int getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	@Override
	public int hashCode() {
		//se usa un numero primo como sal del hash
		final int prime = 31;
		//cada clase debe tener un result distinto
		int result = 3222132;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Profesor))
			return false;
		Profesor other = (Profesor) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + "]";
	}
	
	
    
    


    
}