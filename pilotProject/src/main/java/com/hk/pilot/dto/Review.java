package com.hk.pilot.dto;

import java.util.Date;

public class Review {

	String id;
	int orderNum;
	String snum;
	String content;
	int star;
	int badCnt;
	Date r_date;
	boolean parents_chk;
	int depth;
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
	@Override
	public String toString() {
		return "Review [id=" + id + ", orderNum=" + orderNum + ", snum=" + snum + ", content=" + content + ", star="
				+ star + ", badCnt=" + badCnt + ", r_date=" + r_date + ", parents_chk=" + parents_chk + ", depth="
				+ depth + "]";
	}
	
	
	
}
