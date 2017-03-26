package com.arp.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class Address {
	
	@Column(name = "building_name")
	private String buildingName;
	
	@Column(name = "strret_name")
	private String streetName;
	
	@Column(name = "city")
	private String city;
	
	public Address(){}
	
	public Address(String buildingName,String streetName, String city){
		this.setBuildingName(buildingName);
		this.setStreetName(streetName);
		this.setCity(city);
	}

	public String getBuildingName() {
		return buildingName;
	}

	private void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetName() {
		return streetName;
	}

	private void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

}
