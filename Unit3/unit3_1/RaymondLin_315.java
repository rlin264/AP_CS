package unit3_1;

import java.util.Scanner;

public class RaymondLin_315 
{
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		reverseSequence(kbd);
	}
	public static void reverseSequence(Scanner kbd)
	{
		int n = kbd.nextInt();
		if(n == 0) System.out.println();
		else
		{
			reverseSequence(kbd);
			System.out.printf("%d ", n);
		}
	}
}
