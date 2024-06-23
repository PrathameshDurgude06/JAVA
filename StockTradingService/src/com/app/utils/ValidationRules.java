package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.core.Stock;
import com.app.customException.StockException;

public class ValidationRules {

	public static String validateStock(String sid,String sname,String companyName,Double price,String date,int qty,Map<String,Stock> map) throws StockException
	{
		String msg="Stock not added";
		LocalDate parseDate = parseDate(date);
		String stockId = checkDuplicate(sid, map);
		Stock stock=new Stock(stockId,sname,companyName,price,parseDate,qty);
		map.put(stockId, stock);
		return msg;
	}
	
	public static LocalDate parseDate(String sdate)
	{
		LocalDate date=LocalDate.parse(sdate);
		return date;
	}
	
	public static String checkDuplicate(String sid,Map<String,Stock> map) throws StockException
	{
		if(map.containsKey(sid))
		{
			throw new StockException("Duplicate entry");
		}
		else
		{
			return sid;
		}
	}
}
