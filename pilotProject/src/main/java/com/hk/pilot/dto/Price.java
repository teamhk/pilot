package com.hk.pilot.dto;

public class Price {
	int blouse_p;
	int shirt_p;
	int t_shirt_p;
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
		return "Price [blouse_p=" + blouse_p + ", shirt_p=" + shirt_p + ", t_shirt_p=" + t_shirt_p + "]";
	}
	
	
}
