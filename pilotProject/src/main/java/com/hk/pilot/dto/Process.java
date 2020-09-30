package com.hk.pilot.dto;

public class Process {
	String id;
	int orderNum;
	int wait;
	int ok;
	int pick;
	int wash;
	int end;
	
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
		return "Process [id=" + id + ", orderNum=" + orderNum + ", wait=" + wait + ", ok=" + ok + ", pick=" + pick
				+ ", wash=" + wash + ", end=" + end + "]";
	}
	
	
}
