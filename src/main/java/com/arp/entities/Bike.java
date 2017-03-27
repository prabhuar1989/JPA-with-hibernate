package com.arp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BIKE")
public class Bike extends Vehicle{
	
	
	@Column(name = "SPEEDOMETER")
	private String speedometer;


	public String getSpeedometer() {
		return speedometer;
	}

	public void setSpeedometer(String speedometer) {
		this.speedometer = speedometer;
	}

}
