package com.hk.pilot.dto;

import java.util.Date;

public class Account {
	
	String id;
	int balance;
	Date date;
	int price;
	String derail;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDerail() {
		return derail;
	}
	public void setDerail(String derail) {
		this.derail = derail;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", date=" + date + ", price=" + price + ", derail="
				+ derail + "]";
	}
	
	

}
