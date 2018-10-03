/*File: RaymondLin_154.java
This program finds the indices of the first and last maximum elements.
*/

import java.util.*;


public class RaymondLin_154 
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int x = kbd.nextInt();
		int max = x; 	//max value
		int first = 1; 	//index of first max value
		int last = 1; 	//index of last max value
		int ind = 1; 	//index of current element
		
		while(x!=0)
		{
			if(x==max)
			{
				last = ind;
			}
			if(x>max)
			{
				first = ind;
				last = ind;
				max = x;
			}
			x = kbd.nextInt();
			ind ++;
		}
		
		System.out.println("The index of the first maximum element is " + first);
		System.out.println("The index of the last maximum element is " + last);
		
		kbd.close();
	}
}
