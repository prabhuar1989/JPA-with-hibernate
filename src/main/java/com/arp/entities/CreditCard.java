package com.arp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_CARD")
@PrimaryKeyJoinColumn(name = "CREDIT_CARD_ID")
public class CreditCard extends Card{
	
	@Column(name = "CREDIT_CARD_ID")
	private int creditCardId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "CREDIT_LIMIT")
	private int creditLimit;
	
	@Column(name = "AVAILABLE_CREDIT")
	private int availableCredit;

	public int getCreditCardId() {
		return creditCardId;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public int getAvailableCredit() {
		return availableCredit;
	}

	public void setAvailableCredit(int availableCredit) {
		this.availableCredit = availableCredit;
	}

}
