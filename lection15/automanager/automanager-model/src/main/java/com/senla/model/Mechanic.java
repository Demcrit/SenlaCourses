package com.senla.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Mechanic implements Serializable {
	
	private static final long serialVersionUID = 2474702210933977527L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fullName;
	
	@JsonBackReference
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_order", nullable = true)
	private Order currenOrder;

	public Mechanic(String fullName) {
		this.fullName = fullName;
	}
	
	public Mechanic(Integer id,String fullName) {
		this.id = id;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Order getCurrenOrder() {
		return currenOrder;
	}

	public void setCurrenOrder(Order currenOrder) {
		this.currenOrder = currenOrder;
	}

	@Override
	public String toString() {
		String str = String.format("Mechanic: %s %o", this.fullName, this.currenOrder);
		return str;
	}
	
	  @Override
	    public Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }

}
