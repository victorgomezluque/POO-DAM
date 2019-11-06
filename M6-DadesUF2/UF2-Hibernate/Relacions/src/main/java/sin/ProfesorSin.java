package sin;
import java.io.Serializable;

import javax.persistence.*;

//Todas las tablas son una entidad
@Entity
//Tabla, es el elemento raiz
@Table(name="ProfesorSin")
public class ProfesorSin implements Serializable  {

	//Al contrario que en JAXB, aqui las etiquetas van sobre la declaración de las variables.
	
	//Id, llave primaria
    @Id
    //en los columns identificad el nombre
    @Column(name="Id")
    private int id;
    
    
    /// idUsuario  <--- Java OO
    /// id_usuario  <--- BD
    
    
    //en un column se pueden poner atributos extras como la longitud. Esto creara un VARCHAR(150)
    @Column(name="nombre", length=150)
    private String nombre;
    ///VARCHAR(150)
    
    @Column(name="ape1")
    private String ape1;
    
    @Column(name="ape2")    
    private String ape2;
       

    public ProfesorSin(){ 
    }

    public ProfesorSin(int id, String nombre, String ape1, String ape2) {
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
}