package com.pet;

public class Customer {
	private int cid;
	private String Cpassword;
	public Customer(int cid, String cpassword) {
		super();
		this.cid = cid;
		Cpassword = cpassword;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCpassword() {
		return Cpassword;
	}

	public void setCpassword(String cpassword) {
		Cpassword = cpassword;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", Cpassword=" + Cpassword + "]";
	}
	
}
