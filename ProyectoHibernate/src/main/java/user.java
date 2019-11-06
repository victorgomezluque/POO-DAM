import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="User")
public class user implements Serializable{
	@Id
	@Column(name="user_name")
	private  String UserName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="alias")
	private String alias;
	
	@Temporal(TemporalType.DATE)
    @Column(name="data_Registre")
	private Date dataRegistre;
	
	@Column(name="pathAvatar")
	private String pathAvatar;
	@Column(name="percentatgeVict")
	private Double percentatgeVict;
	
	
	
	
	
	public user() {
		super();
	}
	
	
	
	public user(String userName, String password, String alias, String pathAvatar,
			Double percentatgeVict) {
		super();
		UserName = userName;
		this.password = password;
		this.alias = alias;
		this.pathAvatar = pathAvatar;
		this.percentatgeVict = percentatgeVict;
	}


	

	public user(String userName, String password, String alias, Date dataRegistre, String pathAvatar,
			Double percentatgeVict) {
		super();
		UserName = userName;
		this.password = password;
		this.alias = alias;
		this.dataRegistre = dataRegistre;
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
