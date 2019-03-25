package assignment4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MySavings
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);	//initialize the scanner
		
		PiggyBank p = new PiggyBank(5,5,5,5);	//create a piggy bank object with 5 pennies, nickels, dimes and quarters.
		while(true)
		{
			System.out.println("1. Show total in the bank");	//printing out user options		
			System.out.println("2. Add a penny");
			System.out.println("3. Add a nickel");
			System.out.println("4. Add a dime");
			System.out.println("5. Add a quarter");
			System.out.println("6. Take money out of the bank");
			System.out.println("Enter 0 to quit.\n Enter your choice: ");
			int inp = sc.nextInt();								//allows for user input of an integer
			if(inp == 1) p.showTotal();							//shows total in the piggy bank
			else if(inp == 2) p.addPenny();						//add a penny
			else if(inp == 3) p.addNickel();					//add a nickel
			else if(inp == 4) p.addDime();						//add a dime
			else if(inp == 5) p.addQuarter();					//add a quarter
			else if(inp == 6)
			{
				System.out.println("Enter amount to take out: ");//prompts user for an amount to take out
				p.takeMoney(sc.nextDouble());					 //take out the amount of money entered by the user
			}
			else if(inp == 0) break;							//if input is zero, exit the loop
			else System.out.println("Bad input, try again.");	//input was not in the range 0-6 so the user can try again
		}
		sc.close();												//close the scanner
		p.showTotal();											//show total in bank
	}
}
class PiggyBank											//PiggyBank object that holds coins
{
	private int pennies, nickels, dimes, quarters;		//a PiggyBank has pennies, nickels, dimes and quarters
	private double total;								//value for the total value in the PiggyBank
	DecimalFormat df = new DecimalFormat("#.00");		//DecimalFormat for rounding to 2 decimal places
	
	public PiggyBank()
	{
		pennies = nickels = dimes = quarters = 0;
	}
	public PiggyBank(int pennies, int nickels, int dimes, int quarters)
	{
		this.pennies = pennies;
		this.nickels = nickels;
		this.dimes = dimes;
		this.quarters = quarters;
		this.total = 0.01*pennies + 0.05*nickels + 0.10*dimes + 0.25*quarters;
		this.total = (double)Math.round(this.total * 100d) / 100d;
	}
	public void showTotal()
	{
		total = 0.01*pennies + 0.05*nickels + 0.10*dimes + 0.25*quarters;
		total = (double)Math.round(total * 100d) / 100d;
		System.out.print("Pennies: " + pennies);
		System.out.print(" Nickels: " + nickels);
		System.out.print(" Dimes: " + dimes);
		System.out.println(" Quarters: " + quarters);
		System.out.println("$" + df.format(total));
	}
	public void addPenny()
	{
		pennies += 1;
	}
	public void addNickel()
	{
		nickels += 1;
	}
	public void addDime()
	{
		dimes += 1;
	}
	public void addQuarter()
	{
		quarters += 1;
	}
	public void takeMoney(double money)
	{
		if(money > total)
		{
			System.out.println("Not enough money in bank account");
		}
		else
		{
			while(money >= 0.25 && quarters > 0)
			{
				quarters--;
				money -= 0.25;
				total -= 0.25;
			}
			while(money >= 0.10 && dimes > 0)
			{
				dimes--;
				money -= 0.10;
				total -= 0.10;
			}
			while(money >= 0.05 && nickels > 0)
			{
				nickels--;
				money -= 0.05;
				total -= 0.05;
			}
			while(money >= 0.01 && pennies > 0)
			{
				pennies--;
				money -= 0.01;
				total -= 0.01;
			}
			total = (double)Math.round(total * 100d) / 100d;
		}
	}
}
