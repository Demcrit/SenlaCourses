package com.senla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends Base {

	private String login;
	private String password;

	public User(Long id, String login, String password) {
		super(id);
		this.login = login;
		this.password = password;
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public User() {
	}

	@Column(name = "login")
	public String getLogin() {
		return login;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
