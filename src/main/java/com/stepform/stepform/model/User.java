package com.stepform.stepform.model;
import java.util.List;

import javax.persistence.*;
/*@author()*/

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String email;
	private String pass;
	private String userName;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Post> posts;
	
	public User() {
		
	}
	
	public User(String email, String pass, String userName) {
		this.email = email;
		this.pass = pass;
		this.userName = userName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}



}
