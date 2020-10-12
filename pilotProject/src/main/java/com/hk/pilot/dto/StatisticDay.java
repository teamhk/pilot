package com.hk.pilot.dto;

import java.util.Date;

public class StatisticDay {
	Date cday;
	int oq;
	int op;
	public Date getCday() {
		return cday;
	}
	public void setCday(Date cday) {
		this.cday = cday;
	}
	public int getOq() {
		return oq;
	}
	public void setOq(int oq) {
		this.oq = oq;
	}
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	@Override
	public String toString() {
		return "StatisticDay [cday=" + cday + ", oq=" + oq + ", op=" + op + "]";
	}
	
	
}
