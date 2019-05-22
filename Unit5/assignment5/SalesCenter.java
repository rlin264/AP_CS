package assignment5;

import java.text.NumberFormat;
import java.util.Scanner;

public class SalesCenter 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);					//Initialize scanner to accept user input
		NumberFormat money = NumberFormat.getCurrencyInstance();//Initialize number format to format numbers properly when printing
		
		String input;	//user input String
		int empNum;		//user input for employee number
		double hours;	//user input for employee hours
		
		//Initialize employees
		Employee d = new Manager("Diego", "Martin", 55000);
		Employee k = new Associate("Kylie", "Walter", 18.50);
		Employee m = new Associate("Michael", "Rose", 16.75);
		
		System.out.println("Select one of the following options:");
		
		while(true)
		{
			System.out.println("(E)mloyee Information");
			System.out.println("(P)ay");
			System.out.println("(Q)uit");
			System.out.println("Enter your choice: ");
			input = sc.next(); 	//accept user input
			if(input.toLowerCase().equals("e"))	//first option of employee number. Accept either capital or lowercase
			{
				System.out.println("Enter your employee number (1,2 or 3): ");
				empNum = sc.nextInt();	//user input for employee number
				//call toString method of employees
				if(empNum == 1)
				{
					System.out.println(d.toString());	
				}
				else if(empNum == 2)
				{
					System.out.println(k.toString());
				}
				else
				{
					System.out.println(m.toString());
				}
			}
			else if(input.toLowerCase().equals("p")) //second option of employee pay. Accept either capital or lowercase
			{
				System.out.println("Enter your employee number (1,2 or 3): ");
				empNum = sc.nextInt();
				if(empNum == 1) //Manager
				{
					System.out.println(money.format(d.pay(2)));	//print biweekly pay of the Manager
				}
				else			//Associates
				{
					System.out.println("Enter number of hours worked:");
					hours = sc.nextDouble();					//user input of employee hours
					//print pay of the associate dependent on the hours worked.
					if(empNum == 2)
					{	
						System.out.println(money.format(k.pay(hours)));	
					}
					else
					{
						System.out.println(money.format(m.pay(hours)));
					}
				}
			}
			else	//input of q will lead to a break and exiting of the program.
			{
				break;
			}
		}
		sc.close();
	}
}

//abstract class Employee
abstract class Employee
{
	String firstName, lastName;	//instance variables
	public Employee(String firstName, String lastName) //constructor given first and last names
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	abstract double pay(double period);	//abstract method to calculate pay for a given time period
}
//Manager class which inherits abstract Employee class
class Manager extends Employee
{
	double yearSalary;	//instance variable for yearly salary.

	public Manager(String firstName, String lastName, double yearSalary)//constructor given first/last name and yearly salary.
	{
		super(firstName,lastName);		//give first/last name to superclass constructor
		this.yearSalary = yearSalary;
	}
	public double getSalary()			//accessor for yearSalary
	{
		return yearSalary;
	}
	public double pay(double weeks)		//method pay given an input for the number of weeks.
	{
		return yearSalary/52*weeks;	
	}
	public String toString()			//method to display a string of the relevant ID of the employee.
	{
		return firstName + " " + lastName + ", " + "Manager";
	}
}
//Associate class which inherits abstract Employee class
class Associate extends Employee
{
	double hourPayRate;	//instance variable for the hourly pay rate
	public Associate(String firstName, String lastName, double hourPayRate)	//constructor with a given first/last name and hourly pay rate.
	{
		super(firstName,lastName);		//give first/last name to superclass constructor
		this.hourPayRate = hourPayRate;	
	}
	public double getRate()			//accessor for hourly pay rate
	{
		return hourPayRate;	
	}
	public double pay(double hours)	//calculate pay using hours worked
	{
		return hours*hourPayRate;
	}
	public String toString()		//method to display a string of the relevant ID of the employee.
	{
		return super.firstName + " " + lastName + ", " + "Associate";
	}
}