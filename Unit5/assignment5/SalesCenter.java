package assignment5;

import java.text.NumberFormat;
import java.util.Scanner;

public class SalesCenter 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		NumberFormat money = NumberFormat.getCurrencyInstance();
		
		String input;
		int empNum;
		double hours;
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
			input = sc.next();
			if(input.toLowerCase().equals("e"))
			{
				System.out.println("Enter your employee number (1,2 or 3): ");
				empNum = sc.nextInt();
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
			else if(input.toLowerCase().equals("p"))
			{
				System.out.println("Enter your employee number (1,2 or 3): ");
				empNum = sc.nextInt();
				if(empNum == 1)
				{
					System.out.println(money.format(d.pay(2)));
				}
				else
				{
					System.out.println("Enter number of hours worked:");
					hours = sc.nextDouble();
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
			else
			{
				break;
			}
		}
		
	}
	
}

abstract class Employee
{
	String firstName, lastName;
	public Employee(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	abstract double pay(double period);
}
class Manager extends Employee
{
	double yearSalary;

	public Manager(String firstName, String lastName, double yearSalary)
	{
		super(firstName,lastName);
		this.yearSalary = yearSalary;
	}
	public double getSalary()
	{
		return yearSalary;
	}
	public double pay(double weeks)
	{
		return yearSalary/52*weeks;
	}
	public String toString()
	{
		return super.firstName + " " + lastName + ", " + "Manager";
	}
}
class Associate extends Employee
{
	double hourPayRate;
	public Associate(String firstName, String lastName, double hourPayRate)
	{
		super(firstName,lastName);
		this.hourPayRate = hourPayRate;
	}
	public double getRate()
	{
		return hourPayRate;
	}
	public double pay(double hours)
	{
		return hours*hourPayRate;
	}
	public String toString()
	{
		return super.firstName + " " + lastName + ", " + "Associate";
	}
}