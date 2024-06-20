package bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BankRead {
	public static void main(String[] args)
	{
		
		double sumOfDeposit=0.0;
		double maxDepositAmount=0.0;
		double shoppingExapnced=0.0;
		double maxAmountWithdrawn=0.0;
		String maxWithdrawdate;
		
		try(Scanner sc=new Scanner(System.in);
				BufferedReader buffer=new BufferedReader(new FileReader(sc.nextLine())))
	{
				String line=null;
				
		while((line=buffer.readLine())!=null)
		{
			String[] values=line.split(",");
			String transactionDate=values[0];
			String narration=values[1];
			double withdrawAmount=Double.parseDouble(values[2]);
			double depositAmount=Double.parseDouble(values[3]);
			
			sumOfDeposit +=depositAmount;
			
			if(depositAmount>maxDepositAmount)
			{
				maxDepositAmount=depositAmount;
			}
			
//			if(narration.toLowerCase().contains("Shopping"))
//			{
//				System.out.println("hii");
//				shoppingExapnced+=withdrawAmount;
//			}
			  if (narration.toLowerCase().contains("shopping")) {
				  shoppingExapnced += withdrawAmount;
              }
			  
			if(withdrawAmount>maxAmountWithdrawn)
			{
				maxAmountWithdrawn=withdrawAmount;
				maxWithdrawdate=transactionDate;
			}
				
		}
	}catch (IOException e) {
		e.printStackTrace();
		}
		System.out.println("sum of all deposit = "+sumOfDeposit);
		System.out.println("max deposit amount="+maxDepositAmount);
		System.out.println("shopping expances ="+shoppingExapnced);
		System.out.println("date which max amount withdrawn="+maxAmountWithdrawn);
	}
	

}
