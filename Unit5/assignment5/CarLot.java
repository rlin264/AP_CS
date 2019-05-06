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
		System.out.println("Change Status");
		System.out.println("(1) On the lot");
		System.out.println("(2) In Maintenance");
		System.out.println("(3) Rented Out");
		System.out.println("Enter your choice");
		int inp = sc.nextInt();
		if(inp == 1) status = "on the lot";
		else if(inp == 2) status = "in maintenance";
		else status = "rented out";
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
