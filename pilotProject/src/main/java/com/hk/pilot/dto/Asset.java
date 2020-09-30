package com.hk.pilot.dto;

import java.util.Date;

public class Asset {
	String snum;
	int a_price;
	Date a_date;
	Date period;
	boolean a_check;
	
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public int getA_price() {
		return a_price;
	}
	public void setA_price(int a_price) {
		this.a_price = a_price;
	}
	public Date getA_date() {
		return a_date;
	}
	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public boolean isA_check() {
		return a_check;
	}
	public void setA_check(boolean a_check) {
		this.a_check = a_check;
	}
	@Override
	public String toString() {
		return "Asset [snum=" + snum + ", a_price=" + a_price + ", a_date=" + a_date + ", period=" + period
				+ ", a_check=" + a_check + "]";
	}
	
	
}
