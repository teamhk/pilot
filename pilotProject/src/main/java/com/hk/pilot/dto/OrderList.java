package com.hk.pilot.dto;

import java.util.Date;

public class OrderList {
	
	int orderNum;
	String id;
	String snum;
	String sname;
	String items;
	Date pay_date;
	int pay_price;
	String r_check;
	int bubble;
	int Y1;
	int B1;
	int T1;
	int M1;
	int P1;
	int K1;
	int J1;
	int C1;
	int P2;
	int D1;
	int S1;
	int C2;
	int B2;
	String refund;
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
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
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
	public String getR_check() {
		return r_check;
	}
	public void setR_check(String r_check) {
		this.r_check = r_check;
	}
	public int getBubble() {
		return bubble;
	}
	public void setBubble(int bubble) {
		this.bubble = bubble;
	}
	public int getY1() {
		return Y1;
	}
	public void setY1(int y1) {
		Y1 = y1;
	}
	public int getB1() {
		return B1;
	}
	public void setB1(int b1) {
		B1 = b1;
	}
	public int getT1() {
		return T1;
	}
	public void setT1(int t1) {
		T1 = t1;
	}
	public int getM1() {
		return M1;
	}
	public void setM1(int m1) {
		M1 = m1;
	}
	public int getP1() {
		return P1;
	}
	public void setP1(int p1) {
		P1 = p1;
	}
	public int getK1() {
		return K1;
	}
	public void setK1(int k1) {
		K1 = k1;
	}
	public int getJ1() {
		return J1;
	}
	public void setJ1(int j1) {
		J1 = j1;
	}
	public int getC1() {
		return C1;
	}
	public void setC1(int c1) {
		C1 = c1;
	}
	public int getP2() {
		return P2;
	}
	public void setP2(int p2) {
		P2 = p2;
	}
	public int getD1() {
		return D1;
	}
	public void setD1(int d1) {
		D1 = d1;
	}
	public int getS1() {
		return S1;
	}
	public void setS1(int s1) {
		S1 = s1;
	}
	public int getC2() {
		return C2;
	}
	public void setC2(int c2) {
		C2 = c2;
	}
	public int getB2() {
		return B2;
	}
	public void setB2(int b2) {
		B2 = b2;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	@Override
	public String toString() {
		return "OrderList [orderNum=" + orderNum + ", id=" + id + ", snum=" + snum + ", sname=" + sname + ", items="
				+ items + ", pay_date=" + pay_date + ", pay_price=" + pay_price + ", r_check=" + r_check + ", bubble="
				+ bubble + ", Y1=" + Y1 + ", B1=" + B1 + ", T1=" + T1 + ", M1=" + M1 + ", P1=" + P1 + ", K1=" + K1
				+ ", J1=" + J1 + ", C1=" + C1 + ", P2=" + P2 + ", D1=" + D1 + ", S1=" + S1 + ", C2=" + C2 + ", B2=" + B2
				+ ", refund=" + refund + "]";
	}
		
}
