package com.hk.pilot.dto;

public class Cart {
	String id;
	String items;
	String snum;
	String sname;
	String check;
	int cart_seq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public int getCart_seq() {
		return cart_seq;
	}
	public void setCart_seq(int cart_seq) {
		this.cart_seq = cart_seq;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", items=" + items + ", snum=" + snum + ", sname=" + sname + ", check=" + check
				+ ", cart_seq=" + cart_seq + "]";
	}
	
	

}
