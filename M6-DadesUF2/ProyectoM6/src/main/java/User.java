import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.DateTimeSyntax;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="User")
public class User implements Serializable{
	@Id
	@Column(name="user_name")
	String UserName;
	@Column(name="password")
	String password;
	@Column(name="alias")
	String alias;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataRegistre")
	Date dataRegistre;
	@Column(name="pathAvatar")
	String pathAvatar;
	@Column(name="percentatgeVict")
	Double percentatgeVict;
	
	
	
	
	
	public User() {
		super();
	}
	
	public User(String userName, String password, String alias, Date dataRegistre, String pathAvatar,
			Double percentatgeVict) {
		super();
		UserName = userName;
		this.password = password;
		this.alias = alias;
		this.dataRegistre = new date();
		this.pathAvatar = pathAvatar;
		this.percentatgeVict = percentatgeVict;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Date getDataRegistre() {
		return dataRegistre;
	}
	public void setDataRegistre(Date dataRegistre) {
		this.dataRegistre = dataRegistre;
	}
	public String getPathAvatar() {
		return pathAvatar;
	}
	public void setPathAvatar(String pathAvatar) {
		this.pathAvatar = pathAvatar;
	}
	public Double getPercentatgeVict() {
		return percentatgeVict;
	}
	public void setPercentatgeVict(Double percentatgeVict) {
		this.percentatgeVict = percentatgeVict;
	}
	
	
	
	
	
}
