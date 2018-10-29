/*File Name: RaymondLin_213
This program finds if elements equidistant from the ends are equal to each other. If so, it is a palindrome.
 */

import java.util.*;

public class RaymondLin_213
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int size = kbd.nextInt();
		double[] arr = new double[size];
		boolean is_palindrome = true;
		
		for(int i = 0; i < size; i++)
		{
			arr[i] = kbd.nextDouble();
		}
		for(int i = 0; i < size/2; i++)
		{
			if(arr[i] != arr[size-i-1])
			{
				is_palindrome = false;
				break;
			}
		}
		if(is_palindrome) System.out.println("A Palindrome");
		else System.out.println("Not A Palindrome");
		kbd.close();
	}

}
