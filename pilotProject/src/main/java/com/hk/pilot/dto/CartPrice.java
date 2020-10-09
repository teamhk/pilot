package com.hk.pilot.dto;

import java.util.Date;

public class CartPrice {

	String id;
	String items;
	String snum;
	String sname;
	String c_check="N";
	int cart_seq;
	String choice="Y";
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
	int Y1P;
	int B1P;
	int T1P;
	int M1P;
	int P1P;
	int K1P;
	int J1P;
	int C1P;
	int P2P;
	int D1P;
	int S1P;
	int C2P;
	int B2P;
	Date p_date;
	int p_seq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
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
	public String getCheck() {
		return c_check;
	}
	public void setCheck(String check) {
		this.c_check = check;
	}
	public int getCart_seq() {
		return cart_seq;
	}
	public void setCart_seq(int cart_seq) {
		this.cart_seq = cart_seq;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
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
	public int getY1P() {
		return Y1P;
	}
	public void setY1P(int y1p) {
		Y1P = y1p;
	}
	public int getB1P() {
		return B1P;
	}
	public void setB1P(int b1p) {
		B1P = b1p;
	}
	public int getT1P() {
		return T1P;
	}
	public void setT1P(int t1p) {
		T1P = t1p;
	}
	public int getM1P() {
		return M1P;
	}
	public void setM1P(int m1p) {
		M1P = m1p;
	}
	public int getP1P() {
		return P1P;
	}
	public void setP1P(int p1p) {
		P1P = p1p;
	}
	public int getK1P() {
		return K1P;
	}
	public void setK1P(int k1p) {
		K1P = k1p;
	}
	public int getJ1P() {
		return J1P;
	}
	public void setJ1P(int j1p) {
		J1P = j1p;
	}
	public int getC1P() {
		return C1P;
	}
	public void setC1P(int c1p) {
		C1P = c1p;
	}
	public int getP2P() {
		return P2P;
	}
	public void setP2P(int p2p) {
		P2P = p2p;
	}
	public int getD1P() {
		return D1P;
	}
	public void setD1P(int d1p) {
		D1P = d1p;
	}
	public int getS1P() {
		return S1P;
	}
	public void setS1P(int s1p) {
		S1P = s1p;
	}
	public int getC2P() {
		return C2P;
	}
	public void setC2P(int c2p) {
		C2P = c2p;
	}
	public int getB2P() {
		return B2P;
	}
	public void setB2P(int b2p) {
		B2P = b2p;
	}
	public Date getP_date() {
		return p_date;
	}
	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}
	public int getP_seq() {
		return p_seq;
	}
	public void setP_seq(int p_seq) {
		this.p_seq = p_seq;
	}
	@Override
	public String toString() {
		return "CartPrice [id=" + id + ", items=" + items + ", snum=" + snum + ", sname=" + sname + ", c_check=" + c_check
				+ ", cart_seq=" + cart_seq + ", choice=" + choice + ", Y1=" + Y1 + ", B1=" + B1 + ", T1=" + T1 + ", M1="
				+ M1 + ", P1=" + P1 + ", K1=" + K1 + ", J1=" + J1 + ", C1=" + C1 + ", P2=" + P2 + ", D1=" + D1 + ", S1="
				+ S1 + ", C2=" + C2 + ", B2=" + B2 + ", Y1P=" + Y1P + ", B1P=" + B1P + ", T1P=" + T1P + ", M1P=" + M1P
				+ ", P1P=" + P1P + ", K1P=" + K1P + ", J1P=" + J1P + ", C1P=" + C1P + ", P2P=" + P2P + ", D1P=" + D1P
				+ ", S1P=" + S1P + ", C2P=" + C2P + ", B2P=" + B2P + ", p_date=" + p_date + ", p_seq=" + p_seq + "]";
	}
		
}
