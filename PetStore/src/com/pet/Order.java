package com.pet;

import java.util.Objects;

import com.petenum.Status;

public class Order extends Pet  {

	//Order (orderId, petId, quantity, status)
//	Status is an enum with values like (PLACED, IN_PROCESS, COMPLETED)
	private int orderid;
	private int petid;
	private double quntity;
	private Status status;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(int orderid, int petid, double quntity, Status status) {
		super();
		this.orderid = orderid;
		this.petid = petid;
		this.quntity = quntity;
		this.status = status;
	}
	public Order(int orderid) {
		super();
		this.orderid = orderid;
		}
	
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getPet() {
		return petid;
	}
	public void setPet(int pet) {
		this.petid = pet;
	}
	public double getQuntity() {
		return quntity;
	}
	public void setQuntity(double quntity) {
		this.quntity = quntity;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", pet=" + petid + ", quntity=" + quntity + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(orderid, petid, quntity, status);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return orderid == other.orderid && Objects.equals(petid, other.petid)
				&& Double.doubleToLongBits(quntity) == Double.doubleToLongBits(other.quntity) && status == other.status;
	}
	
	
	
	
	
	
	
	
	
	
}
