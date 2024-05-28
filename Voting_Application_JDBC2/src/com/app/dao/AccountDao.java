package com.app.dao;

import java.sql.SQLException;

public interface AccountDao {
	//add a method for invoking a stored procedure from DB to transfer funds
	String transferFunds(int srcAcNo,int destAcNO,double amount) throws SQLException;
	
	String transferFundsByFunction(int srcNo, int destAcNo, double ammount) throws SQLException;

}
