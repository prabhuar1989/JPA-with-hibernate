package com.arp.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name= "AGE")
	private int age;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "buildingName", column = @Column(name = "HOME_NAME")),
		@AttributeOverride(name = "streetName", column = @Column(name = "HOME_STREET")),
		@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY"))
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "buildingName", column = @Column(name = "OFFICE_NAME")),
		@AttributeOverride(name = "streetName", column = @Column(name = "OFFICE_STREET")),
		@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY"))
	})
	private Address officeAddress;

	public int getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

}
