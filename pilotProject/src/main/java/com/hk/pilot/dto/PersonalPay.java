
package com.hk.pilot.dto;

import java.util.Date;

public class PersonalPay {

	String id;
	String cardCom;
	int cardNum;
	int cardExp;
	int cardCvc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardCom() {
		return cardCom;
	}
	public void setCardCom(String cardCom) {
		this.cardCom = cardCom;
	}
	public int getCardNum() {
		return cardNum;
	}
	public void getCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	public int getCardExp() {
		return cardExp;
	}
	public void setCardExp(int cardExp) {
		this.cardExp = cardExp;
	}
	public int getCardCvc() {
		return cardCvc;
	}
	public void setCardCvc(int cardCvc) {
		this.cardCvc = cardCvc;
	}
	@Override
	public String toString() {
		return "PersonalPay [id=" + id + ", cardCom=" + cardCom + ", cardNum=" + cardNum + ", cardExp=" + cardExp
				+ ", cardCvc=" + cardCvc + "]";
	}

	
	
}
