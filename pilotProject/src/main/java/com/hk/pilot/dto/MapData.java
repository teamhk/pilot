package com.hk.pilot.dto;

public class MapData {
	String snum;
	String sname;
	String Saddress;
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
	public String getSaddress() {
		return Saddress;
	}
	public void setSaddress(String saddress) {
		Saddress = saddress;
	}
	@Override
	public String toString() {
		return "MapData [snum=" + snum + ", sname=" + sname + ", Saddress=" + Saddress + "]";
	}
	
	
}
