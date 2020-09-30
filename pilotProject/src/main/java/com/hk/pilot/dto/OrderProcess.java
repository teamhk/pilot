package com.hk.pilot.dto;

import java.util.Date;

public class OrderProcess {

	int orderNum;
	String id;
	String snum;
	String sname;
	int items;
	Date pay_date;
	int pay_price;
	boolean r_check;
	int bubble;
	int wait;
	int ok;
	int pick;
	int wash;
	int end;
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public int getWait() {
		return wait;
	}
	public void setWait(int wait) {
		this.wait = wait;
	}
	public int getOk() {
		return ok;
	}
	public void setOk(int ok) {
		this.ok = ok;
	}
	public int getPick() {
		return pick;
	}
	public void setPick(int pick) {
		this.pick = pick;
	}
	public int getWash() {
		return wash;
	}
	public void setWash(int wash) {
		this.wash = wash;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "OrderProcess [orderNum=" + orderNum + ", id=" + id + ", snum=" + snum + ", sname=" + sname + ", items="
				+ items + ", pay_date=" + pay_date + ", pay_price=" + pay_price + ", r_check=" + r_check + ", bubble="
				+ bubble + ", wait=" + wait + ", ok=" + ok + ", pick=" + pick + ", wash=" + wash + ", end=" + end + "]";
	}
	
	
}
