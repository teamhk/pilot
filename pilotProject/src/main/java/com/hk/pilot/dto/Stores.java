package com.hk.pilot.dto;

import java.util.Date;

public class Stores {
	String id;
	String sname;
	String saddress;
	String snum;
	String scontact;
	String bank;
	int bnum;
	String permit;
	Date s_date;
	int area_num;
	String sdcheck;
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
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getScontact() {
		return scontact;
	}
	public void setScontact(String scontact) {
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
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
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
	public String getSdcheck() {
		return sdcheck;
	}
	public void setSdcheck(String sdcheck) {
		this.sdcheck = sdcheck;
	}
	@Override
	public String toString() {
		return "Stores [id=" + id + ", sname=" + sname + ", saddress=" + saddress + ", snum=" + snum + ", scontact="
				+ scontact + ", bank=" + bank + ", bnum=" + bnum + ", permit=" + permit + ", s_date=" + s_date
				+ ", area_num=" + area_num + ", sdcheck=" + sdcheck + "]";
	}
	
	
	

}
