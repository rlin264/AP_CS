/*File Name: RaymondLin_221
This program has a function randomize that initializes an array with random integers between two values.
 */

import java.util.*;

public class RaymondLin_221
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int size = kbd.nextInt();
		int[] arr = new int[size];
		int lower = kbd.nextInt();
		int upper = kbd.nextInt();
		randomize(arr, lower, upper);
		System.out.println(Arrays.toString(arr));
		kbd.close();
		
	}
	public static void randomize(int[] data, int lower, int upper)
	{
		for(int i = 0; i < data.length; i++)
		{
			data[i] = lower + (int)(Math.random() * ((upper - lower) + 1));
		}
	}

}
