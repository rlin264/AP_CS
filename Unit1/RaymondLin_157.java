/*File: RaymondLin_157.java
This program finds the sum of the digits of a number
*/

import java.util.*;


public class RaymondLin_157 
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		long x = kbd.nextLong();
		long sum = 0;
		long n = 0;
		
		while(x!=0)
		{
			n = x%10;
			sum += n;
			x = x/10;
		}
		
		System.out.println("The sum of the digits is " + sum);
		
		kbd.close();
	}
}
