package com.app.Contact;

import java.time.LocalDate;

public class Contact {
	//data members
	private String phoneNumber;
	private String name;
	private LocalDate dob;
	private String email;
	
	//constructor
	public Contact(String phoneNumber,String name,LocalDate dob,String email)
	{
		this.phoneNumber=phoneNumber;
		this.name=name;
		this.dob=dob;
		this.email=email;
	}
	
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}

	public String getName() {
		return name;
	}


	public LocalDate getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+" Phone number: "+phoneNumber+" DOB: "+dob+" Email: "+email;
	}
	
	@Override
	public boolean equals(Object o)
	{
		System.out.println("In equals Method");
		if(o instanceof Contact)
			return this.name.equals(((Contact)o).name) && this.dob.equals(((Contact)o).dob);
		return false;
		
	}
	
	@Override
	public int hashCode()
	{
		System.out.println("In hashCode");
		return name.hashCode()+dob.hashCode();
	}

}
