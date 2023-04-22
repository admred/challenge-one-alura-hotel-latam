package com.alura.hotel.models;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	private String password;
	private Date lastTime=new Date(System.currentTimeMillis());
	
	public User() {}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		
	}

	public Long getId() {
		return id;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
