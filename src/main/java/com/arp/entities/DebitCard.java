package com.arp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DEBIT_CARD")
@PrimaryKeyJoinColumn(name = "DEBIT_CARD_ID")
public class DebitCard extends Card{
	
	@Column(name = "DEBIT_CARD_ID")
	private int debitCardId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "BALANCE")
	private int balance;

	public int getDebitCardId() {
		return debitCardId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
