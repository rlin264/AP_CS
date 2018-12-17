package unit3_1;

import java.util.Scanner;

public class RaymondLin_316 
{
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		reverseSequence(kbd);
	}
	public static void reverseSequence(Scanner kbd)
	{
		String n = kbd.next();
		if(n.equals("END")) System.out.println();
		else
		{
			reverseSequence(kbd);
			System.out.printf("%s ", n);
		}
	}
}
