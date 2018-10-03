/*File: RaymondLin_158.java
This program finds the minimum number of multiplications needed to calculate x^n
*/

import java.util.*;


public class RaymondLin_158 
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int n = kbd.nextInt(); //power that a number x is raised to
		int cnt = 0;		   //number of multiplications

		
		while(n>1)
		{
			if(n%2 == 1)
			{
				n -= 1;
			}
			else
			{
				n = n/2;
			}
			cnt ++;
		}
		
		System.out.println("The number of multiplications needed is " + cnt);
		
		kbd.close();
	}
}
