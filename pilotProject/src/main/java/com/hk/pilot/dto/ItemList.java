package com.hk.pilot.dto;

public class ItemList {
	String snum;
	String items;
	String t_shirt;
	String shirt;
	String blouse;
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getT_shirt() {
		return t_shirt;
	}
	public void setT_shirt(String t_shirt) {
		this.t_shirt = t_shirt;
	}
	public String getShirt() {
		return shirt;
	}
	public void setShirt(String shirt) {
		this.shirt = shirt;
	}
	public String getBlouse() {
		return blouse;
	}
	public void setBlouse(String blouse) {
		this.blouse = blouse;
	}
	@Override
	public String toString() {
		return "ItemList [snum=" + snum + ", items=" + items + ", t_shirt=" + t_shirt + ", shirt=" + shirt + ", blouse="
				+ blouse + "]";
	}
	
	
}
