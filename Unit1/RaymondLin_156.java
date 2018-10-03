/*File: RaymondLin_156.java
This program finds the number of local maximums and local minimums in a sequence
*/

import java.util.*;


public class RaymondLin_156
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int x = kbd.nextInt();
		int prev = x;
		int max_cnt = 0; //local maximums count
		int min_cnt = 0; //local minimums count
		boolean max = true;
		boolean min = true;
		
		while(x != 0)
		{
			prev = x;
			x = kbd.nextInt();
			if (x != 0)
			{
				if(max && x < prev)
				{
					max_cnt++;
				}
				else if(min && x > prev)
				{
					min_cnt++;
				}
			}
			else
			{
				if(max)
				{
					max_cnt++;
				}
				else if(min)
				{
					min_cnt++;
				}
			}
			max = x > prev;
			min = x < prev;
		}
		
		System.out.println("The number of local maximums is " + max_cnt);
		System.out.println("The number of local minimums is " + min_cnt);
		
		kbd.close();
	}
}
