package com.hk.pilot.dto;

import java.util.Date;

public class StoreInfo {
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
	int t_shirt;
	int shirt;
	int blouse;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public int getScontact() {
		return scontact;
	}
	public void setScontact(int scontact) {
		this.scontact = scontact;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public boolean isPermit() {
		return permit;
	}
	public void setPermit(boolean permit) {
		this.permit = permit;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public int getArea_num() {
		return area_num;
	}
	public void setArea_num(int area_num) {
		this.area_num = area_num;
	}
	public int getT_shirt() {
		return t_shirt;
	}
	public void setT_shirt(int t_shirt) {
		this.t_shirt = t_shirt;
	}
	public int getShirt() {
		return shirt;
	}
	public void setShirt(int shirt) {
		this.shirt = shirt;
	}
	public int getBlouse() {
		return blouse;
	}
	public void setBlouse(int blouse) {
		this.blouse = blouse;
	}
	@Override
	public String toString() {
		return "StoreInfo [id=" + id + ", sname=" + sname + ", saddress=" + saddress + ", snum=" + snum + ", scontact="
				+ scontact + ", bank=" + bank + ", bnum=" + bnum + ", permit=" + permit + ", s_date=" + s_date
				+ ", area_num=" + area_num + ", t_shirt=" + t_shirt + ", shirt=" + shirt + ", blouse=" + blouse + "]";
	}


}
