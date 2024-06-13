package com.app.core;

import java.util.Objects;

public class Cricketer {
	private String name;
	private int age;
	private String email;
	private String phone;
	private int rating;
	
	public Cricketer(String name, int age, String email, String phone, int rating) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.rating = rating;
	}
	
	public Cricketer(String email) {
		this.email=email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + ", rating="
				+ rating + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Cricketer) {
			Cricketer c=(Cricketer)o;
			return this.email.equals(c.email);
		}
		return false;
		
	}
	
	
	
	

}
