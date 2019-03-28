package assignment4;

import java.util.Scanner;

public class DigitExtractor {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);		//initialize scanner
		System.out.print("Enter an integer: ");		
		Number number = new Number(sc.nextInt());	//initialize number class
		System.out.println();
		while(true)
		{
			System.out.println("Show (W)hole number");			//prompts for user input
			System.out.println("Show (O)nes place number");
			System.out.println("Show (T)ens place number");
			System.out.println("Show (H)undreds place number");
			System.out.println("(Q)uit");
			
			String inp = sc.next();		//user input
			
			//depending on input, do a certain function. Accept capital or lower-case letter for input
			if(inp.equals("W")||inp.equals("w")) System.out.println(number.getWhole());
			else if(inp.equals("O")||inp.equals("o")) System.out.println(number.getOnes());
			else if (inp.equals("T")||inp.equals("t")) System.out.println(number.getTens());
			else if(inp.equals("H")||inp.equals("h")) System.out.println(number.getHundreds());
			else if(inp.equals("Q")||inp.equals("q")) break;
			else
			{
				System.out.println("Bad input");
			}
		}
		sc.close();
	}
}
class Number
{
	private int whole, ones, tens, hundreds; //whole is whole number, ones is ones digit, tens is tens digit, hundreds is hundreds digit
	public Number()	//default constructor
	{
		whole = 100;
		ones = whole%10;			//mod 10 will return the ones digit
		tens = whole%100/10;		//mod 100 will return the ones and tens digits. Integer divide by 10 to get only the tens digit.
		hundreds = whole%1000/100;	//mod 1000 will return the ones, tens and hundreds digits. Integer divide by 100 to return only the hundreds digit.
	}
	public Number(int whole)	//constructor given by a number
	{
		this.whole = whole;
		ones = whole%10;
		tens = whole%100/10;
		hundreds = whole%1000/100;
	}
	public int getWhole()	//accessor for whole
	{
		return whole;
	}
	public int getOnes()	//accessor for ones
	{
		return ones;
	}
	public int getTens()	//accessor for tens
	{	
		return tens;
	}
	public int getHundreds()//accessor for hundreds
	{
		return hundreds;
	}
}
