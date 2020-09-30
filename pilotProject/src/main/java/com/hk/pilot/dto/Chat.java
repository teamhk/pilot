package com.hk.pilot.dto;

import java.util.Date;

public class Chat {
	String id;
	boolean c_check;
	Date c_date;
	String c_content;
	String c_title;
	int depth;
	int c_seq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isC_check() {
		return c_check;
	}
	public void setC_check(boolean c_check) {
		this.c_check = c_check;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getC_seq() {
		return c_seq;
	}
	public void setC_seq(int c_seq) {
		this.c_seq = c_seq;
	}
	@Override
	public String toString() {
		return "Chat [id=" + id + ", c_check=" + c_check + ", c_date=" + c_date + ", c_content=" + c_content
				+ ", c_title=" + c_title + ", depth=" + depth + ", c_seq=" + c_seq + "]";
	}
	
	
	
	
}
