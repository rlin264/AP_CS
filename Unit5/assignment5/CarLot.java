package assignment5;
import java.util.Scanner;

public class CarLot 
{
	public static void main(String[] args) 
	{

	}
}

abstract class Vehicle
{
	int year;
	String make, model, colour, status;
	Scanner sc = new Scanner(System.in);
	
	public void setVehicleStatus()
	{
		int inp = sc.nextInt();
		if(inp == 1) status = "on the lot";
		else if(inp == 2) status = "in maintenance";
		else status = "rented out";
		this.status = status;
	}
	public String getVehicleStatus()
	{
		return status;
	}
	public abstract String toString();
}

class Car extends Vehicle
{
	String fuelType, numDoors;

	public String getVehicleStatus() {
		
		return null;
	}


	public String toString() {

		return null;
	}
	
}
