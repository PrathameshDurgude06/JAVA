package utilities;

import java.util.Scanner;

import vehicle_class.VehicleClass;

public class Tester {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Size: ");
		int n = in.nextInt();
	    VehicleClass[] vehicle = new VehicleClass[n];
		int choice;
		do
		{
			System.out.println("1. Add Vehicle");
			System.out.println("2. Drive Vehicle");
			System.out.println("3. Display Vehical Details");
			System.out.println("4. Exit");
			choice= in.nextInt();
			switch(choice)
			{
			case 1:
				Utilities.addVehicle(vehicle);
				break;
			case 2:
				Utilities.driveVehical();
				break;
			case 3:
				Utilities.displayVehical(vehicle);
				break;
			case 4:
				System.out.println("Exit");
				break;
			}
		}while(choice != 4);
		in.close();
	}	

}
