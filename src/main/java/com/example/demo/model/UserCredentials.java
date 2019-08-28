
package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class UserCredentials {
    @Id
    @Column(name = "username")
    private String userName;
    
    @Column(name = "user_password")
    private String userPassword;
    



    private String Token;

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public UserCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCredentials(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserCredentials [userName=" + userName + ", userPassword=" + userPassword + "]";
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
   
    
}