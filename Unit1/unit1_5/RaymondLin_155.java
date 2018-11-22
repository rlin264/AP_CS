package unit1_5;
/*File: RaymondLin_155.java
This program finds the number of sign changes in a sequence
*/

import java.util.*;


public class RaymondLin_155 
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int x = kbd.nextInt();
		int prev = x;
		int cnt = 0; //sign change count
		
		while(x!=0)
		{
			if((x < 0 && prev > 0)||(x > 0 && prev < 0))
			{
				cnt ++;
			}
			prev = x;
			x = kbd.nextInt();
		}
		
		System.out.println("The number of sign changes is " + cnt);
		
		kbd.close();
	}
}
