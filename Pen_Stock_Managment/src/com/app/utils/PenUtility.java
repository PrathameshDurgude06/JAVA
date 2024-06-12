package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;

import com.app.pen.Pen;

public class PenUtility {

	// add a method to update the stock
	public static String updateStock(Pen pen, int stock, List<Pen> penList) {
		int index = penList.indexOf(pen);
		Pen p1 = penList.get(index);
		p1.setStock(stock + p1.getStock());
		p1.setUpdateDate(LocalDate.now());
		return "Stock is updated";

	}

	// add a method for giving 20% discount for those pen
	// which didn't sold from last 3 months

	public static void addDiscount(List<Pen> penList) {
		for (Pen pen : penList) {
			int years = Period.between(pen.getUpdateDate(), LocalDate.now()).getYears();
			int months = Period.between(pen.getUpdateDate(), LocalDate.now()).getMonths() + years * 12;
			if (months >= 3) {
				double dicountedPrice = pen.getPrice() * 0.20;
				pen.setDiscount(dicountedPrice);
			}
		}
	}

	// add a method to remove pens
	public static void removePen(List<Pen> penList) {
		Iterator<Pen> itr = penList.iterator();
		while(itr.hasNext()) {
			
			int years = Period.between(itr.next().getUpdateDate(), LocalDate.now()).getYears();
			int months = Period.between(itr.next().getUpdateDate(), LocalDate.now()).getMonths()+years*12;
			if(months >=9) {
				itr.remove();
			}
		
	
		}

}}
