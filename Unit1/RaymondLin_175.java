/*File Name: RaymondLin_175
 * This program finds the square root of a number
 */

import java.util.*;

public class RaymondLin_175
{
	
	public static double sqrt(double a)
	{
		double x1 = a;
		double x2 = x1/2 + a/(2*x1);
		
		while(x1 != x2)
		{
			x1 = x2;
			x2 = x1/2 + a/(2*x1);
		}
		
		return x2;
	}
	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int a = kbd.nextInt();
		kbd.close();
		System.out.println("my function: " + sqrt(a));
		System.out.println("Math.sqrt:   " + Math.sqrt(a));
	}

}
