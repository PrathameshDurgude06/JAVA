package com.app.tester;

import static com.app.utils.StockUtils.*;
import static com.app.utils.ValidationRules.*;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Stock;

public class StockTradingService {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Stock> stockMap = populateStock();
			boolean exit = false;
			while (!exit) {
				System.out.println("enter choice");
				System.out.println("1.Add stock\n" + "2.Display stocks\n"
				+"3.Display company wise stocks\n"+"4.Purchase Stocks \n"
						+"5.Sell stocks \n"
						+"0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						// add stocks
						System.out.println("enter stockId,stockName,companyName,price,closingDate,qty");
						System.out.println(validateStock(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.nextInt(),stockMap));
						break;
					case 2:
						// display all stocks
						System.out.println("Displaying stocks:");
						stockMap.values().forEach(v -> System.out.println(v));
						break;
					case 3:
						//display all stocks of a company
						System.out.println("enter companyName:");
						Map<String,Stock> stocks = displayCompanywiseStocks(sc.next(),stockMap);
						stocks.forEach((k,v)->System.out.println(v));
						break;
					case 4:
						System.out.println("enter stockid and quantity to purchase");
						System.out.println(purchaseStocks(sc.next(),sc.nextInt(),stockMap));
						break;
					case 5:
						System.out.println("enter stockid and quantity to sell");
						System.out.println(sellStocks(sc.next(),sc.nextInt(),stockMap));
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
