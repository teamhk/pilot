package com.hk.pilot.dto;

import java.util.Date;

public class UserInfo {
	
	String id;
	String pwd;
	String name;
	String email;
	String pnum;
	String address;
	boolean cardCheck;
	String likeStore;
	boolean udCheck;
	String fidName;
	String fidMail;
	String pwQuestion;
	String pwAnswer;
	String reason;
	boolean grade;
	String cardCom;
	int cardNun;
	Date cardExp;
	int cardCvc;
	int b_price;
	int bubble;
	Date b_date;
	int p_bubble;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isCardCheck() {
		return cardCheck;
	}
	public void setCardCheck(boolean cardCheck) {
		this.cardCheck = cardCheck;
	}
	public String getLikeStore() {
		return likeStore;
	}
	public void setLikeStore(String likeStore) {
		this.likeStore = likeStore;
	}
	public boolean isUdCheck() {
		return udCheck;
	}
	public void setUdCheck(boolean udCheck) {
		this.udCheck = udCheck;
	}
	public String getFidName() {
		return fidName;
	}
	public void setFidName(String fidName) {
		this.fidName = fidName;
	}
	public String getFidMail() {
		return fidMail;
	}
	public void setFidMail(String fidMail) {
		this.fidMail = fidMail;
	}
	public String getPwQuestion() {
		return pwQuestion;
	}
	public void setPwQuestion(String pwQuestion) {
		this.pwQuestion = pwQuestion;
	}
	public String getPwAnswer() {
		return pwAnswer;
	}
	public void setPwAnswer(String pwAnswer) {
		this.pwAnswer = pwAnswer;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public boolean isGrade() {
		return grade;
	}
	public void setGrade(boolean grade) {
		this.grade = grade;
	}
	public String getCardCom() {
		return cardCom;
	}
	public void setCardCom(String cardCom) {
		this.cardCom = cardCom;
	}
	public int getCardNun() {
		return cardNun;
	}
	public void setCardNun(int cardNun) {
		this.cardNun = cardNun;
	}
	public Date getCardExp() {
		return cardExp;
	}
	public void setCardExp(Date cardExp) {
		this.cardExp = cardExp;
	}
	public int getCardCvc() {
		return cardCvc;
	}
	public void setCardCvc(int cardCvc) {
		this.cardCvc = cardCvc;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
	public int getBubble() {
		return bubble;
	}
	public void setBubble(int bubble) {
		this.bubble = bubble;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public int getP_bubble() {
		return p_bubble;
	}
	public void setP_bubble(int p_bubble) {
		this.p_bubble = p_bubble;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", pnum=" + pnum
				+ ", address=" + address + ", cardCheck=" + cardCheck + ", likeStore=" + likeStore + ", udCheck="
				+ udCheck + ", fidName=" + fidName + ", fidMail=" + fidMail + ", pwQuestion=" + pwQuestion
				+ ", pwAnswer=" + pwAnswer + ", reason=" + reason + ", grade=" + grade + ", cardCom=" + cardCom
				+ ", cardNun=" + cardNun + ", cardExp=" + cardExp + ", cardCvc=" + cardCvc + ", b_price=" + b_price
				+ ", bubble=" + bubble + ", b_date=" + b_date + ", p_bubble=" + p_bubble + "]";
	}
	
	

}
