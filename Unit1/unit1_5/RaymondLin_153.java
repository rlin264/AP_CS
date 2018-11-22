package unit1_5;
/*File: RaymondLin_153.java
This program accepts a sequence of integers as input and finds the number of elements with the maximum elements.
*/

import java.util.*;


public class RaymondLin_153 
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int x = kbd.nextInt();
		int max = 0; //max value
		int cnt = 1; //number of maximum elements
		
		while(x!=0)
		{
			if(x==max)
			{
				cnt++;
			}
			if(x>max)
			{
				cnt = 1;
				max = x;
			}
			x = kbd.nextInt();
		}
		
		System.out.println("The number of maximum elements is: " + cnt);
		
		kbd.close();
	}
}
