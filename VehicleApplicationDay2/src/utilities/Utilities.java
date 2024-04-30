package utilities;

import java.util.Date;
import java.util.Scanner;

import custom_exception.InvalidColourException;
import custom_exception.PollutionOutOfRangeException;
import vehicle_class.VehicleClass;
import vehicle_colour.Colour;
import vehicle_validation.VehicleValidation;

public class Utilities {
	static Scanner in = new Scanner(System.in);
	static int count=0;
	
	public static void addVehicle(VehicleClass[] vehicle) {
		try{
			System.out.println("Enter Chassis No: ");
			String chassisNo =in.next();
			Colour colour = null;
		    System.out.println("Enter clour choice WHITE , SILVER , BLACK , RED , BLUE");
		    int choice = in.nextInt();
			colour = VehicleValidation.checkChoice(choice);
			System.out.println("Enter Price");
            double price =in.nextDouble();
            Date manufactureDate = new Date();
            Date insuranceExpDate = new Date();
            System.out.println("Enter Pollution Level");
            double pollutionLevel = in.nextDouble();
            //VehicleValidation.validateColour(colour);
            VehicleValidation.validatePollution(pollutionLevel);
            vehicle[count++] = new VehicleClass( chassisNo,manufactureDate, insuranceExpDate,price,pollutionLevel,colour);
            System.out.println("Vehicle added successfully!");   
		}
		catch(InvalidColourException | PollutionOutOfRangeException e) {
			System.out.println(e.getMessage());
			
		}
	}
	 
	public static void displayVehical(VehicleClass[] vehicle)
	{
		for(int i=0; i<count; i++)
		{
			System.out.println(vehicle[i]);
		}
	}
	
	public static void driveVehical() {
		try {
			System.out.println("Enter Total KM Run");
			double KMDriven =in.nextDouble();
			double pollution = KMDriven*0.002;
			double current_pollutionLevel = 5;
			double pollutionLevel = pollution + current_pollutionLevel;
			VehicleValidation.validatePollution(pollutionLevel);
			
		}
		catch(PollutionOutOfRangeException e)
		{
		System.out.println(e.getMessage());	
		}
		
		
	}

}
