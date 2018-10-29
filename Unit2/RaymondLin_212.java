/*File Name: RaymondLin_212
This program finds the max difference between consecutive elements in a sequence of doubles.
 */

import java.util.*;

public class RaymondLin_212
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int size = kbd.nextInt();
		double[] arr = new double[size];
		double max_diff = 0;
		double n = kbd.nextDouble();
		arr[0] = n;
		
		for(int i = 1; i < size; i++)
		{
			arr[i] = kbd.nextDouble();
			if (arr[i] - arr[i-1] > max_diff)
			{
				max_diff = arr[i] - arr[i-1];
			}
		}
		
		System.out.println(max_diff);
		kbd.close();
	}

}
