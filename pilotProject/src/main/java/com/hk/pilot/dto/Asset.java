package com.hk.pilot.dto;

import java.util.Date;

public class Asset {
	String snum;
	int a_price;
	Date a_date;
	Date periodStart;
	Date periodEnd;
	String a_check;
	int asset_seq;
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
	public Date getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}
	public Date getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}
	public String getA_check() {
		return a_check;
	}
	public void setA_check(String a_check) {
		this.a_check = a_check;
	}
	public int getAsset_seq() {
		return asset_seq;
	}
	public void setAsset_seq(int asset_seq) {
		this.asset_seq = asset_seq;
	}
	@Override
	public String toString() {
		return "Asset [snum=" + snum + ", a_price=" + a_price + ", a_date=" + a_date + ", periodStart=" + periodStart
				+ ", periodEnd=" + periodEnd + ", a_check=" + a_check + ", asset_seq=" + asset_seq + "]";
	}
	
	
	
	
}
