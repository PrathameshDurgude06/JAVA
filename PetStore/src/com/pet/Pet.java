package com.pet;

import java.util.Objects;

import com.petenum.Category;

/**
 * 
 */
public class Pet {

	// ( petId, name, category, unitPrice, stocks)
	// Category is an enum with values like (CAT, DOG, RABBIT, FISH)
	private static int counter = 1;
	private int id;
	private String name;
	private Category category;
	private double price;
	private int stock;

	public Pet() {
		// TODO Auto-generated constructor stub
	}

	public Pet( String name, Category category, double price, int stock) {
		super();
		this.id = counter++;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Pet.counter = counter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", stock=" + stock
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, price, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return category == other.category && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(stock) == Double.doubleToLongBits(other.stock);
	}

}
