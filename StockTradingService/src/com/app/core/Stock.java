package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Stock {

	private String stockId;
	private String stockName;
	private String companyName;
	private double price;
	private LocalDate closingDate;
	private int qty;
	
	//constructors
	public Stock()
	{
		
	}
	
	public Stock(String stockId,String stockName,String companyName,double price,LocalDate closingDate,int qty) {
		this.stockId=stockId;
		this.stockName=stockName;
		this.closingDate=closingDate;
		this.companyName=companyName;
		this.price=price;
		this.qty=qty;
	}
	//getters setters
	

	public String getStockName() {
		return stockName;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	//toString
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", companyName=" + companyName + ", price="
				+ price + ", closingDate=" + closingDate + ", qty=" + qty + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(stockId);
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Stock)
		{
			Stock s=(Stock)o;
			return this.stockId.equals(s.stockId);
		}
		return false;
	}

	
	
}
