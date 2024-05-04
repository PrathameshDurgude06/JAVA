package com.app.PhoneBookApp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

import com.app.Contact.Contact;


public class Tester {

	public static void main(String[] args) throws Exception {
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			HashSet<Contact> contactSet=new HashSet<>();
			while(!exit)
			{
				System.out.println("enter choice: ");
				System.out.println("1.add contact\n"+"2.Display contacts \n"+"0.Exit");
				try {
					switch(sc.nextInt())
					{
					case 1:
						//add contact
						System.out.println("Enter PhoneNumber, Name, DOB, EmailID");
						Contact contact=new Contact(sc.next(),sc.next(),LocalDate.parse(sc.next()),sc.next());
						contactSet.add(contact);
						break;
					case 2:
						//display
						for(Contact c : contactSet)
							System.out.println(c);
						break;
					case 0:
						exit=true;
						break;


					}
				}
				catch(Exception e)
				{
					throw new Exception("Invalid");
				}
			}

		}
	}

}
