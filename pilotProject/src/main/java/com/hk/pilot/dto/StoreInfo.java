package com.hk.pilot.dto;

import java.util.Date;

public class StoreInfo {
	
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
	String items;
	String t_shirt;
	String shirt;
	String blouse;
	int orderNum;
	String content;
	int star;
	int badCnt;
	Date r_date;
	String parents_chk;
	int depth;
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
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getBadCnt() {
		return badCnt;
	}
	public void setBadCnt(int badCnt) {
		this.badCnt = badCnt;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	public String getParents_chk() {
		return parents_chk;
	}
	public void setParents_chk(String parents_chk) {
		this.parents_chk = parents_chk;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "StoreInfo [id=" + id + ", sname=" + sname + ", saddress=" + saddress + ", snum=" + snum + ", scontact="
				+ scontact + ", bank=" + bank + ", bnum=" + bnum + ", permit=" + permit + ", s_date=" + s_date
				+ ", area_num=" + area_num + ", sdcheck=" + sdcheck + ", items=" + items + ", t_shirt=" + t_shirt
				+ ", shirt=" + shirt + ", blouse=" + blouse + ", orderNum=" + orderNum + ", content=" + content
				+ ", star=" + star + ", badCnt=" + badCnt + ", r_date=" + r_date + ", parents_chk=" + parents_chk
				+ ", depth=" + depth + "]";
	}
	
	
}
