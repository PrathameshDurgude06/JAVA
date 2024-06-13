package com.app.tester;

import static com.app.utils.CricketerUtils.updateRating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.core.Cricketer;
import com.app.custom_ordering.CricketerRatingComparator;
import com.app.utils.CricketerUtils;

public class CricketerTest {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			boolean exit =false;
			
			List<Cricketer> clist=new ArrayList<>();
			while(!exit) {
				System.out.println("Options :\n"+"1.Add Player\n"+"2.Modify Cricketer's Rating\n"
			+"3.Search Cricketer by Name\n"+"4.Display all Cricketers\n"+"5.Display Cricketers sort by rating");
				System.out.println("Select Option from Menu");
				try {
					switch(sc.nextInt()) {
					case 1:System.out.println("Enter Cricketer's Name,Age,Email Id,Phone No,Rating :"); 
						Cricketer ckt=new Cricketer(sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.nextInt());
						clist.add(ckt);	
						break;
						
					case 2:System.out.println("Enter Cricketer's Email Id,new rating");
						System.out.println(updateRating(sc.next(),sc.nextInt(),clist));
						break;
						
					case 3: System.out.println("Enter the cricleter's name");
					Cricketer ckt1=CricketerUtils.searchCricketerByName(sc.next(),clist);
					System.out.println(ckt1);
					break;
					
					case 4:System.out.println("List of all Cricketers");
					for(Cricketer c:clist)
						System.out.println(c);
						break;
					
					case 5:System.out.println("Sorted Cricketers as per Rating");
						Collections.sort(clist, new CricketerRatingComparator());
						break;
						
					case 0: exit=true;
					break;
				}
					
				}catch(Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
			
		}

	}

}
