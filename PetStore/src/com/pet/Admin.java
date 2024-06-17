package com.pet;

public class Admin {

	private int aid;
	private String password;
	
	public Admin(int aid, String password) {
		super();
		this.aid = aid;
		this.password = password;
	}
	public Admin(int aid) {
		
		this.aid = aid;
	
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", password=" + password + "]";
	}
	
	
}
