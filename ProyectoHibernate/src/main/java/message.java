import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


enum Type {
	text, imatge, audio, video;
}

@Entity
@Table(name = "message")
public class message implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	//@JoinColumn(name="sender")
	private user sender;

	@Column(name = "receiver")
	private user receiver;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type type;

	@Column(name = "content")
	private String content;

	@Column(name = "date")
	private Date date;

}
