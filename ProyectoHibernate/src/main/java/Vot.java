import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vot")
public class Vot implements Serializable {
	@Id
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@Column(name = "sender")
	private user sender;
	
	@OneToOne
	@Column(name = "reciver")
	private user reciver;

	@Column(name = "partida")
	private partida Partida;

	@Column(name = "torn")
	private int torn;

}
