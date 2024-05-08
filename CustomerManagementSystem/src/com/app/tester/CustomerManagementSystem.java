package com.app.tester;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.coreclasses.Customer;
import com.app.utils.CMSValidations;
import com.app.utils.CustomerUtils;
import static com.app.utils.IOUtils.*;

public class CustomerManagementSystem {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
			try (Scanner sc = new Scanner(System.in)) {
				// init phase
				boolean exit = false;
				// init D.S
				List<Customer> customerList = new ArrayList<>();// size : 0 , init cap 10
				while (!exit) {
					System.out.println("Options :\n"+" 1. Sign Up\n"+" 2. Sign In all\n"+" 3. Change Password\n"+" 4. Display All Customers\n"
							+" 5. Un Subscribe\n"+" 6. Display Customers sorted by email (asc)\n"
							+" 7. Display customer details sorted as per the dob n last name\n"+" 8. Remove Customer details\n"
							+" 9. Store Data in binary file\n"+" 10. Restore details from Binary file\n"+" 0. Exit");
					
					System.out.println("Select Option from Menu");
					try {
						switch (sc.nextInt()) {
						case 1: // register new customer
							System.out.println(
									"Enter customer details : firstName,  lastName,  email,  password, regAmount,  dob,  plan");
							Customer customer =CMSValidations.validateCustomerInputs(sc.next(), sc.next(), sc.next(),
									sc.next(),sc.nextDouble(), sc.next(), sc.next(), customerList);
							//=> all i/ps are valid
							customerList.add(customer);
							System.out.println("Registration Successfull");
							break;
							
						case 2: System.out.println("Enter Email id and password");
						customer=CustomerUtils.validateSignIn(sc.next(),sc.next(),customerList);
						System.out.println("Login Successfull " +customer);
						break;
						
						case 3:System.out.println("Enter email id and old password and new password");
						customer=CustomerUtils.validateSignIn(sc.next(),sc.next(),customerList);
						customer.setPassword(sc.next());
						System.out.println("Paaword Changed Successfully");
					
						case 4:
							for(Customer c : customerList)
								System.out.println(c);
							break;
							
						case 5:System.out.println("Enter email to un subscribe");
						System.out.println(CustomerUtils.deleteCustomerDetails(sc.next(),customerList));
						
						case 6:Collections.sort(customerList);
						break;
						
						case 7:Collections.sort(customerList,new Comparator<Customer>() {
							@Override
							public int compare(Customer c1,Customer c2)
							{
								int retVal = c1.getDob().compareTo(c2.getDob());
								if (retVal == 0) {
									// compare as per desc last name
									int i=c1.getLastName().compareTo(c2.getLastName());
										return i;
										
								}
								return retVal;	
							}
						});
						break;
						
						case 8:System.out.println("Enter Service Plan and Specified Date to remove customer");
						customer=CustomerUtils.removeCustomerByPlanAndDob(sc.next(),sc.next(),customerList);
						System.out.println("Customer details removed sucessfully"+customer);
						break;
						
						case 9:Map<String,Customer>custMap=new HashMap<>();
							for(Customer c: customerList) {
							custMap.put(c.getEmail(),c);
							System.out.println("Enter File name to store details");
							writeDetails(custMap,sc.next());
						}
							break;
						
						case 10:System.out.println("Enter file name to read details");
							Map<String,Customer>map=readDetails(sc.next());
							System.out.println("Student details -");
							map.forEach((k,v) -> System.out.println(v));
							break;
							
						case 0:
							exit = true;
							break;
						}
						
					} catch (Exception e) {
						sc.nextLine();
						System.out.println(e);// toString
					}
						
				}
				
			}

		}


}