package com.hk.pilot.dto;

import java.util.Date;

public class ReviewItems {

	String id;
	int orderNum;
	String snum;
	String content;
	int star;
	int badCnt;
	Date r_date;
	boolean parents_chk;
	int depth;
	String sname;
	int items;
	Date pay_date;
	int pay_price;
	boolean r_check;
	int bubble;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
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
	public boolean isParents_chk() {
		return parents_chk;
	}
	public void setParents_chk(boolean parents_chk) {
		this.parents_chk = parents_chk;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public boolean isR_check() {
		return r_check;
	}
	public void setR_check(boolean r_check) {
		this.r_check = r_check;
	}
	public int getBubble() {
		return bubble;
	}
	public void setBubble(int bubble) {
		this.bubble = bubble;
	}
	@Override
	public String toString() {
		return "ReviewItems [id=" + id + ", orderNum=" + orderNum + ", snum=" + snum + ", content=" + content
				+ ", star=" + star + ", badCnt=" + badCnt + ", r_date=" + r_date + ", parents_chk=" + parents_chk
				+ ", depth=" + depth + ", sname=" + sname + ", items=" + items + ", pay_date=" + pay_date
				+ ", pay_price=" + pay_price + ", r_check=" + r_check + ", bubble=" + bubble + "]";
	}
	
	
	
}
