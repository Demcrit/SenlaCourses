package com.senla.service;

import org.springframework.stereotype.Component;

@Component
public class UserStorage {

	public UserStorage() {

	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
