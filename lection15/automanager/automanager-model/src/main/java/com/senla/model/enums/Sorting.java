package com.senla.model.enums;

public enum Sorting {
	id("id"), name("fullName"), work("work"), price("price"), sdate("startDate"), rdate("requestDate"), edate("endDate");

	private String type;

	Sorting(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
