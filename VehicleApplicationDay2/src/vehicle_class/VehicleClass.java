package vehicle_class;
import java.util.Date;

import vehicle_colour.Colour;

public class VehicleClass {
		private String chassisNo;
		private Date manufactureDate;
		private Date insuranceExpDate;
		private double pollutionLevel;
		private double price;
		private Colour colour;
		
		public VehicleClass(String chassisNo, Date manufactureDate, Date insuranceExpDate,double price, double pollutionLevel, Colour colour) {
			this.chassisNo = chassisNo;
			this.manufactureDate = manufactureDate;
			this.insuranceExpDate = insuranceExpDate;
			this.price =price;
			this.pollutionLevel = pollutionLevel;
			this.colour= colour;
		}

		public String toString() {
			return "Chasis No: "+ chassisNo
					+" Manufacturing Date: "+manufactureDate
					+" Price: "+price
					+" Insurance Expiry Date: "+insuranceExpDate
					+" Pollution Level: "+pollutionLevel
					+" Colour: "+colour;
		}
		public String getChasisNo() {
			return chassisNo;
		}

		public Date getManufactureDate() {
			return manufactureDate;
		}

		public Date getInsuranceExpDate() {
			return insuranceExpDate;
		}

		public double getPollutionLevel() {
			return pollutionLevel;
		}
		
		public void setPollutionLevel(double pollutionLevel) {
			this.pollutionLevel = pollutionLevel;
		}

		public Colour getColour() {
			return colour;
		}
		
		public double getPrice() {
			return price;
		}
		
		public void setPrice(double price) {
			this.price=price;
			
		}

}
