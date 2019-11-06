import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partida")
public class partida implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private  int id;
	
	@Column(name = "users")
	private user Users;
	
	@Column(name = "torn")
	private  int torn;
	
	@Column(name = "xat")
	private message xat;

	
	
	

}
