package Llops;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	
	
	@Id
	@Column (name = "user_name")
	String userName;
	
	@Column (name = "password")
	String password;
	
	@Column (name = "alies")
	String alias;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "data_registre")
	Date dataRegistre;
	
	@Column (name = "path_avatar")
	String pathAvatar;
	
	@Column (name = "percentatge_victories")
	double percentatgeVictories;

	public User() {
		
	}
	
	
	public User(String userName, String password, String alias, String pathAvatar) {
		super();
		this.userName = userName;
		this.password = password;
		this.alias = alias;
		this.dataRegistre = new Date();
		this.pathAvatar = pathAvatar;
		this.percentatgeVictories = 0;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public double getPercentatgeVictories() {
		return percentatgeVictories;
	}

	public void setPercentatgeVictories(double percentatgeVictories) {
		this.percentatgeVictories = percentatgeVictories;
	}
	
	
	
	
	
	

}
