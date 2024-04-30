package vehicle_validation;

import custom_exception.InvalidColourException;
import custom_exception.PollutionOutOfRangeException;
import vehicle_colour.Colour;

public class VehicleValidation {
	public static final double MAX_PUC;
	static {
		MAX_PUC = 30;
	}
	
	//below two methods are for the colour validation
	
	/*
	 * public static void validateColour(Colour colour) throws
	 * InvalidColourException
	 * { for (Colour c : Colour.values()) 
	 * { if (c == colour)
	 *  {
	 * 		return; } 
	 * throw new InvalidColourException("Invalid color! Please choose from WHITE, SILVER, BLACK, RED, BLUE."
	 * ); } }
	 */
	
	
	  public static Colour checkChoice(int choice) throws InvalidColourException {
	  Colour colour=null; 
	  if(choice==1) { colour = Colour.WHITE; }
	  else if(choice==2) { colour = Colour.SILVER; }
	  else if(choice==3) 
	  { colour =Colour.BLACK; }
	  else if(choice==4) { colour = Colour.RED; }else if (choice==5)
	  { colour = Colour.BLUE; }else { throw new
	  InvalidColourException("Colour Not Found"); } return colour; }
	 
	
	public static void validatePollution(double pollutionLevel) throws  PollutionOutOfRangeException {
		if(pollutionLevel > MAX_PUC)
			throw new  PollutionOutOfRangeException("Pollution Level of Vehicle is MAX");
		else
			System.out.println("Kindly Drive a vehical upto 2000 km after that check Pollution level");
	}
}

