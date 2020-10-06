package com.hk.pilot.dto;

import java.util.Date;

public class Account {
	
	String id;
	int balance;
	Date date;
	int o_price;
	String detail;
	int i_price;
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
	public int getO_price() {
		return o_price;
	}
	public void setO_price(int o_price) {
		this.o_price = o_price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getI_price() {
		return i_price;
	}
	public void setI_price(int i_price) {
		this.i_price = i_price;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", date=" + date + ", o_price=" + o_price + ", detail="
				+ detail + ", i_price=" + i_price + "]";
	}
	
}
