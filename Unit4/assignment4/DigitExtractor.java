package assignment4;

import java.util.Scanner;

public class DigitExtractor {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		Number number = new Number(sc.nextInt());
		System.out.println();
		while(true)
		{
			System.out.println("Show (W)hole number");
			System.out.println("Show (O)nes place number");
			System.out.println("Show (T)ens place number");
			System.out.println("Show (H)undreds place number");
			System.out.println("(Q)uit");
			
			String inp = sc.next();
			
			if(inp.equals("W")||inp.equals("w")) number.getWhole();
			else if(inp.equals("O")||inp.equals("o")) number.getOnes();
			else if (inp.equals("T")||inp.equals("t")) number.getTens();
			else if(inp.equals("H")||inp.equals("h")) number.getHundreds();
			else if(inp.equals("Q")||inp.equals("q")) break;
			else
			{
				System.out.println("Bad input");
			}
		}
	}
}
class Number
{
	private int whole, ones, tens, hundreds;
	public Number()
	{
		whole = 100;
		ones = whole%10;
		tens = whole%100/10;
		hundreds = whole%1000/100;
	}
	public Number(int whole)
	{
		this.whole = whole;
		ones = whole%10;
		tens = whole%100/10;
		hundreds = whole%1000/100;
	}
	public void getWhole()
	{
		System.out.println(whole);
	}
	public void getOnes()
	{
		System.out.println(ones);
	}
	public void getTens()
	{	
		System.out.println(tens);
	}
	public void getHundreds()
	{
		System.out.println(hundreds);
	}
}
