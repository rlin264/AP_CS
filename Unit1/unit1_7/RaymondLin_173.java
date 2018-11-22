package unit1_7;
/*File Name: RaymondLin_173
 * This program finds the LCM of 2 numbers.
 */

import java.util.*;

public class RaymondLin_173 
{
	
	public static int lcm(int a, int b)
	{
		int min = Math.min(a,b); 
		int max = Math.max(a,b); 
		int rem = max % min;
		while ( rem != 0 )
		{ 
			max = min ;
			min = rem ;
			rem = max % min ;
		}
		
		int gcf = min;
		
		return (a*b / gcf);
	}
	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int a = kbd.nextInt();
		int b = kbd.nextInt();
		kbd.close();
		System.out.println(lcm(a,b));
		

	}

}
