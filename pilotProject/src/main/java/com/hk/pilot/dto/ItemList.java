package com.hk.pilot.dto;

public class ItemList {
	int snum;
	int t_shirt;
	int shirt;
	int blouse;
	/**
	 * @return the snum
	 */
	public int getSnum() {
		return snum;
	}
	/**
	 * @param snum the snum to set
	 */
	public void setSnum(int snum) {
		this.snum = snum;
	}
	/**
	 * @return the t_shirt
	 */
	public int getT_shirt() {
		return t_shirt;
	}
	/**
	 * @param t_shirt the t_shirt to set
	 */
	public void setT_shirt(int t_shirt) {
		this.t_shirt = t_shirt;
	}
	/**
	 * @return the shirt
	 */
	public int getShirt() {
		return shirt;
	}
	/**
	 * @param shirt the shirt to set
	 */
	public void setShirt(int shirt) {
		this.shirt = shirt;
	}
	/**
	 * @return the blouse
	 */
	public int getBlouse() {
		return blouse;
	}
	/**
	 * @param blouse the blouse to set
	 */
	public void setBlouse(int blouse) {
		this.blouse = blouse;
	}
	@Override
	public String toString() {
		return "ItemList [snum=" + snum + ", t_shirt=" + t_shirt + ", shirt=" + shirt + ", blouse=" + blouse + "]";
	}
	
	

}
