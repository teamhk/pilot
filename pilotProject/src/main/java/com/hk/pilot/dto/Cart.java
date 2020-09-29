package com.hk.pilot.dto;

public class Cart {
	String id;
	int items;
	String snum;
	String sname;
	boolean check;
	int cart_seq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
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
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
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
