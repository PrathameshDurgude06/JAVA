package com.app.penval;

import java.time.LocalDate;
import java.util.List;

import com.app.pen.Brand;
import com.app.pen.Color;
import com.app.pen.InkColor;
import com.app.pen.Material;
import com.app.pen.Pen;
import com.app.penexception.PenException;

public class PenVal {
//	private Brand brand;
//	private Color color;
//	private InkColor inkColor;
//	private Material material;
//	private int stock;
//	private LocalDate updateDate;
//	private LocalDate listDate;
//	private double price;
//	private double discount
	public static Pen validateInput(String brand,
			String color,String inkColor, String material,
			int stock, String updateDate, String listDate,
			double price, double discount) {
		LocalDate updateDate1 = LocalDate.parse(updateDate);
		LocalDate listDate1 = LocalDate.parse(listDate);
		Brand brand1 = validateBrand(brand);
		Color color1 = validateColor(color);
		InkColor inkcolor1 = validateInkColor(inkColor);
		Material material1 = validateMaterial(material);
		
	return new Pen(brand1,color1,inkcolor1,material1,stock,updateDate1,listDate1,price,discount);	
	}
	public static Brand validateBrand(String brand) {
		Brand brand1 = Brand.valueOf(brand.toUpperCase());
		return brand1;
	}
	public static Color validateColor(String color) {
		Color color1 = Color.valueOf(color.toUpperCase());
		return color1;
	}
	public static InkColor validateInkColor(String inkColor) {
		InkColor inkcolor1 = InkColor.valueOf(inkColor.toUpperCase());
		return inkcolor1;
	}
	public static Material validateMaterial(String material) {
		Material material1 = Material.valueOf(material.toUpperCase());
		return material1;
	}
	
	public static Pen validatePen(int pen_id, List<Pen> penList) throws PenException {
		
		Pen pen = new Pen(pen_id);
		if (penList.contains(pen)) {
		return pen;
		}
		throw new PenException("No such pen exists");	
		}
	
}
