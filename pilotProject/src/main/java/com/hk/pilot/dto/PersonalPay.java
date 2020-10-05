
package com.hk.pilot.dto;

import java.util.Date;

public class PersonalPay {

	String id;
	String cardCom;
	int cardNun;
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
	public int getCardNun() {
		return cardNun;
	}
	public void setCardNun(int cardNun) {
		this.cardNun = cardNun;
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
		return "PersonalPay [id=" + id + ", cardCom=" + cardCom + ", cardNun=" + cardNun + ", cardExp=" + cardExp
				+ ", cardCvc=" + cardCvc + "]";
	}

	
	
}
