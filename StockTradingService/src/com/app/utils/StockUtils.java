package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Stock;
import com.app.customException.StockException;

public class StockUtils {
	public static Map<String,Stock> populateStock()
	{
		//stockId,stockName,companyName,price,closingDate,qty
		Map<String,Stock> map=new HashMap<>();
		Stock s1=new Stock("s1","stock1","com1",100,LocalDate.of(2024, 07, 9),50);
		Stock s2=new Stock("s2","stock2","com1",200,LocalDate.of(2024, 8, 9),100);
		Stock s3=new Stock("s3","stock3","com3",150,LocalDate.of(2024, 07, 15),60);
		Stock s4=new Stock("s4","stock4","com1",300,LocalDate.of(2024, 10, 19),30);
		Stock s5=new Stock("s5","stock5","com5",500,LocalDate.of(2024, 11, 3),150);
		Stock[] stocks= {s1,s2,s3,s4,s5};
		for(Stock s:stocks)
		{
			map.put(s.getStockId(),s);
		}
		return map;
	}
	
	public static Map<String,Stock> displayCompanywiseStocks(String companyName,Map<String,Stock> map) throws StockException
	{
		Map<String,Stock> stockMap=new HashMap<>();
		boolean found=false;
		for(Stock s:map.values())
		{
			if(s.getCompanyName().equals(companyName))
			{
				stockMap.put(s.getStockId(),s);
				found=true;
			}
		}
		if (!found) {
		    throw new StockException("invalid company name");
		}
		
		return stockMap;
	}
	
	public static String purchaseStocks(String stockId,int qty,Map<String,Stock> stocks) throws StockException
	{
		boolean found=false;
		String msg="not purchased";
		for(Stock s:stocks.values())
		{
			if(s.getStockId().equals(stockId))
			{
				s.setQty(s.getQty()+qty);
				msg="stock purchased";
				found=true;
			}
		}
		if (!found) {
		    throw new StockException("Invalid stock id or insufficient quantity");
		}
		return msg;
	}
	
	public static String sellStocks(String stockId,int qty,Map<String,Stock> stocks) throws StockException
	{
		boolean found=false;
		String msg="not sold";
		for(Stock s:stocks.values())
		{
			if(s.getStockId().equals(stockId) && s.getQty()>=qty)
			{
				s.setQty(s.getQty()-qty);
				msg="stock sold";
				found=true;
			}
		}
		if (!found) {
		    throw new StockException("Invalid stock id or insufficient quantity");
		}
		return msg;
	}

}
