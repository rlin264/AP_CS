/*File: RaymondLin_151.java
This program accepts a sequence of integers as inputs and finds the sum of all the negative elements.
*/

import java.util.*;


public class RaymondLin_151 
{

	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int x = kbd.nextInt();
		int sum = 0; //sum of negative elements
		
		while(x!=0)
		{
			if(x<0)
			{
				sum += x;
			}
			x = kbd.nextInt();
		}
		
		System.out.println("The sum of all the negative elements is: " + sum);
		
		kbd.close();
	}
}
