import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class rol {

	@Id
	@Column(name = "nom")
	private String nom;

	@Column(name = "freq")
	private int freq;

	@Column(name = "pathImg")
	private String pathImg;

	@Column(name = "descripcio")
	private String descripcio;

	
	
}
