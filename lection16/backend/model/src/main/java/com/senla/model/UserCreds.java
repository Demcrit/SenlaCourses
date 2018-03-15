package com.senla.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_creds")
public class UserCreds extends Base {
	private User user;
	private String name;
	private String surname;
	private String email;

	public UserCreds() {
	}

	public UserCreds(User user, Long id, String name, String surname, String email) {
		super(id);
		this.user = user;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public UserCreds(User user, String name, String surname, String email) {
		this.user = user;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "surname")
	public String getSurname() {
		return surname;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}