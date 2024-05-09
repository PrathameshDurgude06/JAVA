package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.coreclasses.Customer;
import com.app.coreclasses.ServicePlan;
import com.app.custom_exception.CMSException;


public class CMSValidations {

	public static void checkForDupCustomer(String email, List<Customer> customerList) throws CMSException {
		// 1. create customer class instance wrapping PK
		Customer newCust = new Customer(email);
		if (customerList.contains(newCust))
			throw new CMSException("This EmailId is already Registered !!!!");
		 
	}

	// add a method to parse n validate plan n it's charges
	public static ServicePlan parseAndValidatePlanAndCharges(String plan, double regAmount) throws CMSException {
		//1. parse string(plan) -- > enum
		ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());
		// plan is valid , now check if reg amount is correct
		if (servicePlan.getPlanCost() == regAmount)
			return servicePlan;
		// => incorrect reg amount : throw custom exc
		throw new CMSException("Reg amount doesn't match with the chose plan cost");

	}

	// add a method to validate all i/ps
	public static Customer validateCustomerInputs(String firstName, String lastName, String email, String password,
			double regAmount, String dob, String plan, List<Customer> customers) throws CMSException {
		// 1 . check for dup
		checkForDupCustomer(email, customers);
		ServicePlan servicePlan = parseAndValidatePlanAndCharges
				(plan, regAmount);
		LocalDate bithDate = LocalDate.parse(dob);
		validateEmail(email);
		validatePassword(password);
		parseAndValidateDob(dob);
		// => all i/ps are valid , ret validated customer details to the caller
		return new Customer(firstName, lastName, 
				email, password, regAmount, bithDate, servicePlan);
	}
	
	public static void validatePassword(String password) throws CMSException
	{
		String regEx="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*]).{5,20})";
		if(!password.matches(regEx))
			throw new CMSException("Invalid Password ");
	}
	
	public static void validateEmail(String email) throws CMSException
	{
		String mail="^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+(com|org|net)$";
		if(!email.matches(mail))
			throw new CMSException("Invalid Email");
	}
	
	public static LocalDate parseAndValidateDob(String dob) throws CMSException
	{
		LocalDate date=LocalDate.parse(dob);
		if(Period.between(date,LocalDate.now()).getYears()<21)
			throw new CMSException("You are Minor to creat ACcount");
		return date;
		
	}
}
