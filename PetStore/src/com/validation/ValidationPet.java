package com.validation;

import java.util.ArrayList;

import com.pet.Admin;
import com.pet.Order;
import com.pet.Pet;
import com.petenum.Category;
import com.petenum.Status;
import com.petexception.Customexception;

public class ValidationPet {
	
	public static ArrayList<Pet> populatedlist(){		    
		ArrayList<Pet>list=new ArrayList<>();
//		String name, Category category, double price, double stock
//		  petId = 101, name=” Bull Dog”, category= DOG, unitPrice= 1000, stocks=50

		list.add(new Pet("Bull_Dog", Category.DOG, 10000, 15));
		list.add(new Pet(" Percian_cat", Category.CAT, 1000, 10));	
		list.add(new Pet("Dolfin", Category.FISH, 25000, 5));
		list.add(new Pet("Indian_Dog", Category.DOG, 2000,6));
		return list;
	}
	
//	int orderid, int petid, double quntity, Status status
		
	public static ArrayList<Order> populatedorderlist(){
		ArrayList<Order>list =new ArrayList<>();
		//orderId=1, petId=101, quantity=5, status=PLACED
	  list.add(new Order(1, 101, 8, Status.COMPLETED));	
	  list.add(new Order(2, 102, 5, Status.PLACED));
	  list.add(new Order(3, 103, 2, Status.IN_PROCESS));
		return list;
	}
	
	public  static boolean adminvaltidate(int id, String pass) throws Customexception {
		//login
		Admin c=new Admin(id, pass);

  	    if(c.getAid()==id) {
  	    	if(c.getPassword().equals(pass)) {
  	    		return true;
  	    	}
  	    }
	       throw new Customexception("Wrong input") ;
}
	
}
