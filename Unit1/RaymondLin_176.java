/*File Name: RaymondLin_176
 * This program finds the cubed root of a number
 */

import java.util.*;

public class RaymondLin_176
{
	
	public static double cbrt(double a)
	{
		double x1 = a;
		double x2 = 2* x1/3 + a/(3*x1*x1);
		
		while(x1 != x2)
		{
			x1 = x2;
			x2 = 2* x1/3 + a/(3*x1*x1);
		}
		
		return x2;
	}
	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int a = kbd.nextInt();
		kbd.close();
		System.out.println("my function: " + cbrt(a));
		System.out.println("Math.sqrt:   " + Math.pow(a, 1.0/3));
	}

}
