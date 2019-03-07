package assignment4;

import java.util.Scanner;

public class MySavings
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		PiggyBank p = new PiggyBank(5,5,5,5);
		while(true)
		{
			System.out.println("1. Show total in the bank");
			System.out.println("2. Add a penny");
			System.out.println("3. Add a nickel");
			System.out.println("4. Add a dime");
			System.out.println("5. Add a quarter");
			System.out.println("6. Take money out of the bank");
			System.out.println("Enter 0 to quit.\n Enter your choice: ");
			int inp = sc.nextInt();
			if(inp == 1) p.showTotal();
			else if(inp == 2) p.addPenny();
			else if(inp == 3) p.addNickel();
			else if(inp == 4) p.addDime();
			else if(inp == 5) p.addQuarter();
			else if(inp == 6)
			{
				System.out.println("Enter amount to take out: ");
				p.takeMoney(sc.nextDouble());
			}
			else break;
		}
		p.showTotal();
	}
}
class PiggyBank
{
	private int pennies, nickels, dimes, quarters;
	private double total;
	
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
	}
	public void showTotal()
	{
		total = 0.01*pennies + 0.05*nickels + 0.10*dimes + 0.25*quarters;
		System.out.print("Pennies: " + pennies);
		System.out.print(" Nickels: " + nickels);
		System.out.print(" Dimes: " + dimes);
		System.out.println(" Quarters: " + quarters);
		System.out.println("$" + total);
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
			while(money > 0.25 && quarters > 0)
			{
				quarters--;
				money -= 0.25;
			}
			while(money > 0.10 && dimes > 0)
			{
				dimes--;
				money -= 0.10;
			}
			while(money > 0.05 && nickels > 0)
			{
				nickels--;
				money -= 0.05;
			}
			while(money > 0.01 && pennies > 0)
			{
				pennies--;
				money -= 0.01;
			}
			total = (double)Math.round(money * 100d) / 100d;
		}
	}
}
