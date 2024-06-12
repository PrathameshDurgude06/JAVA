package com.app.pen;

import java.time.LocalDate;
import java.util.Objects;

public class Pen {
	
//	a.	ID (unique identifier for each Pen, should be generated automatically)
//	b.	Brand (Example:  Cello, Parker, Reynolds etc.)
//	c.	Color//enum
//	d.	InkColor//enum
//	e.	Material (Example: Plastic, Alloy Steel, Metal etc.)
//	f.	Stock (Available quantity)
//	g.	Stock Update Date (it changed every time when admin update stock or user order executed)
//	h.	Stock Listing Date (date on which product is added to site for sale)
//	i.	Price (in INR) 
//	j.	Discounts (in percentage)
	
	private int pen_id;
	private Brand brand;
	private Color color;
	private InkColor inkColor;
	private Material material;
	private int stock;
	private LocalDate updateDate;
	private LocalDate listDate;
	private double price;
	private double discount;
	private static int idGenerator;
	
	
	public Pen(Brand brand, Color color, InkColor inkColor, Material material, int stock, LocalDate updateDate,
			LocalDate listDate, double price, double discount) {
		super();
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.updateDate = updateDate;
		this.listDate = listDate;
		this.price = price;
		this.discount = discount;
		this.pen_id=++idGenerator;
	}


	public Pen(int pen_id) {
		this.pen_id=pen_id;
	}

	
	

	public int getPen_id() {
		return pen_id;
	}


	public void setPen_id(int pen_id) {
		this.pen_id = pen_id;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public InkColor getInkColor() {
		return inkColor;
	}


	public void setInkColor(InkColor inkColor) {
		this.inkColor = inkColor;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public LocalDate getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}


	public LocalDate getListDate() {
		return listDate;
	}


	public void setListDate(LocalDate listDate) {
		this.listDate = listDate;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public static int getIdGenerator() {
		return idGenerator;
	}


	public static void setIdGenerator(int idGenerator) {
		Pen.idGenerator = idGenerator;
	}


	@Override
	public String toString() {
		return "Pen [pen_id=" + pen_id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor
				+ ", material=" + material + ", stock=" + stock + ", updateDate=" + updateDate + ", listDate="
				+ listDate + ", price=" + price + ", discount=" + discount + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(pen_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pen)) {
			return false;
		}
		Pen other = (Pen) obj;
		return pen_id == other.pen_id;
	}



	
	
	
	

}
