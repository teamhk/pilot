package com.hk.pilot.dto;

public class CartPrice {

	String id;
	int items;
	String snum;
	String sname;
	String check;
	int cart_seq;
	int blouse_p;
	int shirt_p;
	int t_shirt_p;
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
	public int getBlouse_p() {
		return blouse_p;
	}
	public void setBlouse_p(int blouse_p) {
		this.blouse_p = blouse_p;
	}
	public int getShirt_p() {
		return shirt_p;
	}
	public void setShirt_p(int shirt_p) {
		this.shirt_p = shirt_p;
	}
	public int getT_shirt_p() {
		return t_shirt_p;
	}
	public void setT_shirt_p(int t_shirt_p) {
		this.t_shirt_p = t_shirt_p;
	}
	@Override
	public String toString() {
		return "CartPrice [id=" + id + ", items=" + items + ", snum=" + snum + ", sname=" + sname + ", check=" + check
				+ ", cart_seq=" + cart_seq + ", blouse_p=" + blouse_p + ", shirt_p=" + shirt_p + ", t_shirt_p="
				+ t_shirt_p + "]";
	}
	
	
	
}
