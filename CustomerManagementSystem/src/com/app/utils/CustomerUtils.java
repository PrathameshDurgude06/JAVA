
package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.app.coreclasses.*;

import com.app.coreclasses.Customer;
import com.app.custom_exception.CMSException;

public class CustomerUtils {

	public static Customer validateSignIn(String email, String password, List<Customer> list) throws CMSException{
		Customer cst=new Customer(email);
		int index = list.indexOf(cst); 
		if (index == -1) 
			throw new CMSException("Invalid Email ID");
		Customer cust=list.get(index);
		if(cust.getPassword().equals(password)) {
			return cust;
		}
		throw new CMSException("Invalid Password");	
	}

	public static String deleteCustomerDetails(String email, List<Customer> customerList) throws CMSException{
		
		int index=customerList.indexOf(new Customer(email));
		if(index == -1)
			throw new CMSException("Email not found");
		Customer cst=customerList.remove(index);
		return "Un Subscribe Successfull" +cst.getFirstName()+" "+cst.getLastName();
		
	}

	public static Customer removeCustomerByPlanAndDob(String plan,String sdate,List<Customer> customerList) {
		// TODO Auto-generated method stub
		Customer cst = null;
		Iterator<Customer> iterator = customerList.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            ServicePlan splan=ServicePlan.valueOf(plan.toUpperCase());
            LocalDate date=LocalDate.parse(sdate);
            if (customer.getDob().isAfter(date) && customer.getPlan()==splan) 
            {
                // Remove the customer if born after the specified date
            	cst=iterator.next();
                iterator.remove();
            }
        }
        return cst;
	} 
}