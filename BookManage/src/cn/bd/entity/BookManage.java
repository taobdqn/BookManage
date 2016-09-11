package cn.bd.entity;

import java.util.Date;

public class BookManage {
	private int b_id;
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	
	public int getB_bype() {
		return b_bype;
	}
	public void setB_bype(int b_bype) {
		this.b_bype = b_bype;
	}
	private String b_name;
	private String b_author;
	
	private int b_bype;
	
	
	
	
	private Date b_time;
	public Date getB_time() {
		return b_time;
	}
	public void setB_time(Date b_time) {
		this.b_time = b_time;
	}
}
