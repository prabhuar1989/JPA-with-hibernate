package com.arp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Car")
public class Car extends Vehicle{
	
	
	@Column(name = "SEATER")
	private int seater;


	public int getSeater() {
		return seater;
	}

	public void setSeater(int seater) {
		this.seater = seater;
	}

}
