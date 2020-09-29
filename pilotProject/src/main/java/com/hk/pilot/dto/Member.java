package com.hk.pilot.dto;

public class Member {
	
	String id;
	String pwd;
	String name;
	String email;
	int pnum;
	String address;
	boolean cardCheck;
	String likeStore;
	boolean udCheck;
	String fidName;
	String fidMail;
	String pwQuestion;
	String pwAnswer;
	String reason;
	String grade;
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
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", pnum=" + pnum
				+ ", address=" + address + ", cardCheck=" + cardCheck + ", likeStore=" + likeStore + ", udCheck="
				+ udCheck + ", fidName=" + fidName + ", fidMail=" + fidMail + ", pwQuestion=" + pwQuestion
				+ ", pwAnswer=" + pwAnswer + ", reason=" + reason + ", grade=" + grade + "]";
	}
		
	

}
