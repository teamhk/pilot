package com.hk.pilot.dto;

import java.util.Date;

public class Stores {
	String id;
	String sname;
	String saddress;
	int snum;
	int scontact;
	String bank;
	int bnum;
	boolean permit;
	Date s_date;
	int area_num;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * @return the saddress
	 */
	public String getSaddress() {
		return saddress;
	}
	/**
	 * @param saddress the saddress to set
	 */
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
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
	 * @return the scontact
	 */
	public int getScontact() {
		return scontact;
	}
	/**
	 * @param scontact the scontact to set
	 */
	public void setScontact(int scontact) {
		this.scontact = scontact;
	}
	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * @return the bnum
	 */
	public int getBnum() {
		return bnum;
	}
	/**
	 * @param bnum the bnum to set
	 */
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	/**
	 * @return the permit
	 */
	public boolean isPermit() {
		return permit;
	}
	/**
	 * @param permit the permit to set
	 */
	public void setPermit(boolean permit) {
		this.permit = permit;
	}
	/**
	 * @return the s_date
	 */
	public Date getS_date() {
		return s_date;
	}
	/**
	 * @param s_date the s_date to set
	 */
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	/**
	 * @return the area_num
	 */
	public int getArea_num() {
		return area_num;
	}
	/**
	 * @param area_num the area_num to set
	 */
	public void setArea_num(int area_num) {
		this.area_num = area_num;
	}
	@Override
	public String toString() {
		return "Stores [id=" + id + ", sname=" + sname + ", saddress=" + saddress + ", snum=" + snum + ", scontact="
				+ scontact + ", bank=" + bank + ", bnum=" + bnum + ", permit=" + permit + ", s_date=" + s_date
				+ ", area_num=" + area_num + "]";
	}
	
	
	
	
	
	

}
