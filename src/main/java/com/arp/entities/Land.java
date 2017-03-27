package com.arp.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Land")
public class Land extends Property{
	
	@Column(name = "LOCATION", nullable = true)
	private String location;
	
	@Column(name = "TOTAL_AREA", nullable = true)
	private int totalArea;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(int totalArea) {
		this.totalArea = totalArea;
	}

}
