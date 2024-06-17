package com.tester;

import static com.validation.ValidationPet.adminvaltidate;
import static com.validation.ValidationPet.populatedlist;
import static com.validation.ValidationPet.populatedorderlist;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.pet.Order;
import com.pet.Pet;
import com.petenum.Category;
import com.petenum.Status;
import com.petexception.Customexception;

public class TestPet {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ArrayList<Pet> petlist = populatedlist();
			ArrayList<Order> orderlist = populatedorderlist();
			boolean exit = false;
			while (!exit) {
				System.out.println();
				System.out.println("Options:\n"+"1:Login\n" + "2:Admin Login to add new pet\n" + "3:update pet details (Admin only)\n"
						+ "4:Dispaly All Pet\n" + "5:display Order details\n" + "6: Order Pet\n" + "7:check order status by Order Id\n"
						+ "8:update order status(Admin only functionality) \n" + "9:exit\n");
				System.out.println("Select Option from Menu:");
				switch (sc.nextInt()) {

				case 1:
					// login
					System.out.println("Enter id:");
					int pid = sc.nextInt();
					petlist.stream().filter(i -> i.getId() == pid).forEach(System.out::println);
					System.out.println("Login Successful.....");
					break;

				case 2:
					// admin login to add new pet
					System.out.println("Enter Id and Password.");
					int id = sc.nextInt();
					String pass = sc.next();
					boolean b = adminvaltidate(id, pass);
					if (b) {
					//String name, Category category, double price, double stock
						System.out.println("Enter name,Category,price and stock of Pet");
						petlist.add(new Pet(sc.next(), Category.valueOf(sc.next().toUpperCase()), sc.nextDouble(),
								sc.nextInt()));
						System.out.println(" Pet add Successfully.....");

					} else {
						throw new Customexception("Invalid details are entInvalidered");

					}
					break;

				case 3:
					// Update Pet details (Admin only functionality)

					System.out.println("Enter  Admin Id and Password.");
					boolean admin = adminvaltidate(sc.nextInt(),sc.next());
					if(admin) {
						System.out.println("Enter Pet Id to update");
						int index=petlist.indexOf(sc.nextInt());
						if (index != 0) {
							System.out.println("Enter name,Category,price and stock of Pet");
							petlist.set(index,new Pet(sc.next(),Category.valueOf(sc.next().toUpperCase()),sc.nextDouble(),sc.nextInt()));
						}
						else {
							throw new Customexception("Invalid details are entInvalidered");
						}
					}
					break;

				case 4:
					System.out.println("Display Pet Details....\n");
					petlist.forEach(System.out::println);
					break;

				case 5:
					System.out.println("Display Order Details....\n");
					orderlist.forEach(System.out::println);

				case 6:
					// Order a Pet
					System.out.println("Enter Pet Name:");  
					String name=sc.next();
					petlist.stream().filter(i->i.getName().equalsIgnoreCase(name)).forEach(System.out::println);
					System.out.println();
					break;

				case 7:
					// Check order status by Order Id
					System.out.println("Enter id For cheking Status...");
					int oid = sc.nextInt();
					System.out.println("Status=" + orderlist.get(oid).getStatus());
					break;

				case 8:
					// Update order status (Admin only functionality)
					System.out.println("Enter id For Update Status...");
					Order o = new Order(sc.nextInt());
					o.setStatus(Status.valueOf(sc.next().toUpperCase()));
					System.out.println("Status Updetaed.....");
					break;
					
				case 9:
					exit = true;
					System.out.println("Thank you....");
					break;
				}

			}

		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
