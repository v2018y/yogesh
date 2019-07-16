package com.vany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column
	private String username;
	
	@NotNull
	@Column
	@JsonIgnore
	private String password;
	
	
	@OneToMany(mappedBy = "daoUser")
	private Set<Bar> bar =new HashSet<Bar>();
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Bar> getBar() {
		return bar;
	}

	public void setBar(Set<Bar> bar) {
		this.bar = bar;
	}

}
