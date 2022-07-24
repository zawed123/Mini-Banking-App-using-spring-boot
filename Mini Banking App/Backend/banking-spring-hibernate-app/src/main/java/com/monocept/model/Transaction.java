package com.monocept.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private long id;
	private double amount;
	private String type;
	private Date dateTime;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(referencedColumnName = "name")
	private Account account;
	
	public Transaction() {}

	public Transaction(double amount, String type) {
		this.amount = amount;
		this.type = type;
		this.dateTime = generateDateTime();
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public Timestamp generateDateTime() {
		Date date = new Date();
		long millis = date.getTime();
		Timestamp timestamp = new Timestamp(millis);
		return timestamp;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
		
	}
}
