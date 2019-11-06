import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="xatmessage")
public class xatmessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JoinColumn(name="sender")
	@OneToMany(mappedBy = "partida")
	private Set<user> sender;
	
	@JoinColumn(name="sender")
	@OneToMany(mappedBy = "partida")
	private Set<partida> Partida;
	
	@Column(name="content")
	private String content;
	
	@Column(name="date")
	private Date date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<user> getSender() {
		return sender;
	}
	public void setSender(Set<user> sender) {
		this.sender = sender;
	}
	public Set<partida> getPartida() {
		return Partida;
	}
	public void setPartida(Set<partida> partida) {
		Partida = partida;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "xatmessage [id=" + id + ", sender=" + sender + ", Partida=" + Partida + ", content=" + content
				+ ", date=" + date + "]";
	}
	public xatmessage() {
		super();
	}
	
	
	
	

}
