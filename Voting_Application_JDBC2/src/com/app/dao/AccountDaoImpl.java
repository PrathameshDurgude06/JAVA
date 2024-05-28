package com.app.dao;

import static com.app.utils.DBUtils.closeConnection;
import static com.app.utils.DBUtils.openConnection;

//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Types;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import java.sql.CallableStatement;

public class AccountDaoImpl implements AccountDao {
	private Connection cn;
	private CallableStatement cst1,cst2;

	public AccountDaoImpl() throws SQLException {
		// get db cn from db utils
		cn = openConnection();
		// create cst to invoke stored proc
		cst1=(CallableStatement) cn.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		//register OUT params
		cst1.registerOutParameter(4,Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("acct DAO created...");
		
		cst2=cn.prepareCall("{?=call transfer_funds_func(?,?,?)}");
		cst2.registerOutParameter(1,Types.DOUBLE);

	}

	@Override
	public String transferFunds(int srcAcNo, int destAcNO, double amount) throws SQLException {
		//set In params
		cst1.setInt(1,srcAcNo);
		cst1.setInt(2, destAcNO);
		cst1.setDouble(3, amount);
		//execute proc
		cst1.execute();
		return "Updated src bal: "+cst1.getDouble(4)+" dest Balance: "+cst1.getDouble(5);
		
	}
	
	@Override
	public String transferFundsByFunction(int srcNo, int destAcNo, double ammount) throws SQLException {
		cst2.setInt(2, srcNo);
		cst2.setInt(3, destAcNo);
		cst2.setDouble(4, ammount);
		
		cst2.execute();
		return "Dest balance"+cst2.getDouble(1);
		
	}
	
	public void cleanUp() throws SQLException
	{
		if(cst1!=null)
			cst1.close();
		closeConnection();
		System.out.println("account dao cleanup");
		
	}

}
