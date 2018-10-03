/*File: RaymondLin_152.java
This program accepts a sequence of integers as inputs and finds the average of all the even elements.
*/

import java.util.*;

public class RaymondLin_152 
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int x = kbd.nextInt();
		int sum = 0; //sum of even elements
		int cnt = 0; //number of even elements
		
		while(x!=0)
		{
			if(x%2 == 0)
			{
				sum += x;
				cnt ++;
			}
			x = kbd.nextInt();
		}
		
		System.out.println("The sum of all the negative elements is: " + (double)(sum)/(double)(cnt));
		
		kbd.close();
	}
}
