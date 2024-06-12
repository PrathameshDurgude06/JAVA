package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.pen.Brand;
import com.app.pen.Color;
import com.app.pen.InkColor;
import com.app.pen.Material;
import com.app.pen.Pen;
import com.app.penval.PenVal;
import com.app.utils.PenUtility;

public class Client {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Pen> penList = new ArrayList<>();
			boolean exit = false;
			while (!exit) {
				System.out.println("-------MENU----------");
				System.out.println("1.Add Pen \n2.Display pen details \n3.Update Stock of pen "
						+ "\n4.Set discount of 20% for all the pens which " + "are not at all sold in last 3 months "
						+ "\n5.Remove Pens which are never sold once listed in 9 months" + "\n6 Exit");
				System.out.println("Enter Your Choice:");
				int choice = sc.nextInt();
				try {
					switch (choice) {
					case 1:
						// for adding pen
//						private Brand brand;
//						private Color color;
//						private InkColor inkColor;
//						private Material material;
//						private int stock;
//						private LocalDate updateDate;
//						private LocalDate listDate;
//						private double price;
//						private double discount
						System.out.println(
								"Enter brand,color,ink-color," + "material,stock,update-date,list-date,price,discount");
						Pen pen = PenVal.validateInput(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(),
								sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble());
						penList.add(pen);
						System.out.println("Data enterd successfully");
						break;

					case 2:
						// for displaying pen
						for (Pen p : penList) {
							System.out.println(p);
							//System.out.println(penList.indexOf(p));
						}
						
						break;

					case 3:
						// for updating stocks
						System.out.println("Enter the Pen ID");
						Pen p1 = PenVal.validatePen(sc.nextInt(), penList);
						System.out.println("Enter the stock");
						System.out.println(PenUtility.updateStock(p1, sc.nextInt(), penList));
						break;

					case 4:
						// Set discount of 20% for all the pens which are
						// not at all sold in last 3 months
						PenUtility.addDiscount(penList);
						System.out.println("Discount added successfully");
						break;
						
					case 5:
						PenUtility.removePen(penList);
						System.out.println("Pen Removed successfully");
						break;
					case 6:
						exit = true;
						System.out.println("Exiting.....");
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}

}
