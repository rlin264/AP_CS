package assignment4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class LunchOrder {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);			//initialize the scanner
		DecimalFormat df = new DecimalFormat("#.00");	//initialize DecimalFormat to round to two decimal places
		
		double total = 0;							//initialize total cost of food
		
		//initialize food items
		Food hamburger = new Food(1.85, 9, 33, 1);	
		Food salad = new Food(2.00, 1, 11, 5);
		Food fries = new Food(1.30, 11, 36, 4);
		Food soda = new Food(0.95, 0, 38, 0);
		
		//ask for number of hamburgers and print cost/nutrition.
		System.out.print("Enter number of hamburgers: ");
		total += sc.nextInt()*hamburger.getPrice();	//add cost of a user input number of hamburgers
		System.out.println("Each hamburger has " + hamburger.getFat() + "g of fat, " + hamburger.getCarbs() + 
				"g of carbs and " + hamburger.getFiber() + "g of fiber.");
		
		//ask for number of salads and print cost/nutrition.
		System.out.print("\nEnter number of salads: ");
		total += sc.nextInt()*salad.getPrice();		//add cost of a user input number of salads
		System.out.println("Each salad has " + salad.getFat() + "g of fat, " + salad.getCarbs() + 
				"g of carbs and " + salad.getFiber() + "g of fiber.");
		
		//ask for number of fries and print cost/nutrition.
		System.out.print("\nEnter number of fries: ");
		total += sc.nextInt()*fries.getPrice();		//add cost of a user input number of fries
		System.out.println("Each fries has " + fries.getFat() + "g of fat, " + fries.getCarbs() + 
				"g of carbs and " + fries.getFiber() + "g of fiber.");
		
		//ask for number of sodas and print cost/nutrition.
		System.out.print("\nEnter number of sodas: ");
		total += sc.nextInt()*soda.getPrice();		//add cost of a user input number of sodas
		System.out.println("Each soda has " + soda.getFat() + "g of fat, " + soda.getCarbs() + 
				"g of carbs and " + soda.getFiber() + "g of fiber.");
		
		sc.close();
		System.out.println("\n Your total comes to: $" + df.format(total));	//print out the total and round number to total decimals
	}
}

class Food
{
	private double price, fat, carbs, fiber;
	public Food(double price, double fat, double carbs, double fiber)
	{
		this.price = price;
		this.fat = fat;
		this.carbs = carbs;
		this.fiber = fiber;
	}
	public double getPrice()	//accessor for price
	{
		return price;
	}
	public double getFat()		//accessor for fat
	{
		return fat;
	}
	public double getCarbs()	//accessor for carbs
	{
		return carbs;
	}
	public double getFiber()	//accessor for fiber
	{
		return fiber;
	}
}
