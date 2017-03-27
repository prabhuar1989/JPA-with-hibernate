package com.arp.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("House")
public class House extends Property{
	
	@Column(name = "BUILDG_NAME", nullable = true)
	private String buildingName;

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

}
