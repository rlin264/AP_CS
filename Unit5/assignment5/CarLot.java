package assignment5;
import java.util.Scanner;

public class CarLot 
{
	public static void main(String[] args) 
	{
		String inp, veh;	//initialize input for selection of info, status or quit and veh to accept input of the vehicle.
		Scanner sc = new Scanner(System.in);	//initialize scanner
		Vehicle h = new Minivan(2019, "Honda", "Odyssey", "White", "on the lot", "Gas", 4, 3);	//create a minivan object
		Vehicle c = new Car(2019, "Toyota", "Corolla", "Red", "on the lot", "Gas", 2);			//create a car object
		Vehicle t = new Truck(2018, "Dodge", "Ram", "Grey", "on the lot", "Diesel", 4, 8);		//create a truck object
		
		while(true)
		{
			System.out.println("Select one of the following options");
			System.out.println("(V)ehicle Information");
			System.out.println("(S)tatus");
			System.out.println("(Q)uit");
			System.out.println("Enter your choice: ");
			inp = sc.next();	//user input to choose between vehicle info, status and quit.
			if(!inp.toLowerCase().equals("v") && !inp.toLowerCase().equals("s")) break; //if input is not 'v' or 's'  
			else	//if input is either v or s.
			{
				System.out.println("Select Vehicle: ");
				System.out.println("(C)ar");
				System.out.println("(M)inivan");
				System.out.println("(T)ruck");
				System.out.println("Enter your choice: ");
				veh = sc.next();	//user input for which vehicle to choose
				if(inp.toLowerCase().equals("v"))	//vehicle information
				{
					//print the appropriate information depending on the vehicle
					if(veh.toLowerCase().equals("c")) System.out.println(c.toString() + "\n" +c.getVehicleStatus());
					else if(veh.toLowerCase().equals("m")) System.out.println(h.toString() + "\n" +h.getVehicleStatus());
					else System.out.println(t.toString() + "\n" + t.getVehicleStatus());
				}
				else if(inp.toLowerCase().equals("s"))	//vehicle status
				{
					//change vehicle status for the selected vehicle.
					if(veh.toLowerCase().equals("c"))
					{
						c.setVehicleStatus();
						System.out.println(c.getVehicleStatus());
					}
					else if(veh.toLowerCase().equals("h")) 
					{
						h.setVehicleStatus();
						System.out.println(h.getVehicleStatus());
					}
					else 
					{
						t.setVehicleStatus();
						System.out.println(t.getVehicleStatus());
					}
			}
		}
		}
		sc.close();
	}
}

class Vehicle
{
	//declaration of instance variables
	int year;
	String make, model, colour, status;
	
	Scanner sc = new Scanner(System.in); //initialize scanner
	public Vehicle(int year, String make, String model, String colour, String status)	//constructor for vehicle
	{
		this.year = year;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.status = status;
	}
	public void setVehicleStatus()		//set the status of a vehicle. This method is the same for all subclasses and is available through this superclass.
	{
		System.out.println("Change Status");
		System.out.println("(1) On the lot");
		System.out.println("(2) In Maintenance");
		System.out.println("(3) Rented Out");
		System.out.println("Enter your choice");
		int inp = sc.nextInt();		//ask for user input to choose what the status is
		//change status depending on input
		if(inp == 1) status = "on the lot";
		else if(inp == 2) status = "in maintenance";
		else status = "rented out";
	}
	public String getVehicleStatus()	//return string for vehicle status
	{
		return "The vehicle is " + status;
	}
	public String toString()			//return string giving vehicle info.
	{
		return year +  " " + make + " " + model + "\n" + colour;
	}
}
//class Car that inherits the Vehicle class
class Car extends Vehicle
{
	String fuelType;
	int numDoors;

	public Car(int year, String  make, String model, String colour, String status, String fuelType, int numDoors) //constructor for Car
	{
		super(year, make, model, colour, status);	//feed these parameters to the superclass constructor
		this.fuelType = fuelType;
		this.numDoors = numDoors;
	}
	public String toString() {	//output the vehicle information in a string

		return year +  " " + make + " " + model + "\n" + colour + "\n" + fuelType + ", " + numDoors + " doors";
	}
}
//class Minivan that inherits the Vehicle class
class Minivan extends Vehicle
{
	String fuelType;
	int numDoors, rowsSeats;

	public Minivan(int year, String  make, String model, String colour, String status, String fuelType, int numDoors, int rowsSeats)	//constructor for Minivan
	{
		super(year, make, model, colour, status);	//feed these parameters to the superclass constructor
		this.fuelType = fuelType;
		this.numDoors = numDoors;
		this.rowsSeats = rowsSeats;
	}
	public String toString() //output the vehicle information in a string
	{
		return year +  " " + make + " " + model + "\n" + colour + "\n" + fuelType + ", " + numDoors + " doors" + ", " + rowsSeats + " rows of seats";
	}
}
class Truck extends Vehicle
{
	String fuelType;
	int numDoors, engineCylinders;

	public Truck(int year, String  make, String model, String colour, String status, String fuelType, int numDoors, int engineCylinders)	//constructor for Truck
	{
		super(year, make, model, colour, status);	//feed these parameters to the superclass constructor
		this.fuelType = fuelType;
		this.numDoors = numDoors;
		this.engineCylinders = engineCylinders;
	}
	public String toString() //output the vehicle information in a string
	{
		return year +  " " + make + " " + model + "\n" + colour + "\n" + fuelType + ", " + numDoors + engineCylinders + " engine cylinders";
	}
}
