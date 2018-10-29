/*File Name: RaymondLin_222
This program has a function randomize that shuffles an array
 */

import java.util.*;

public class RaymondLin_222
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int[] arr = new int[]{1,2,3,4,5};
		shuffle(arr);
		System.out.println(Arrays.toString(arr));
		kbd.close();
		
	}
	public static void shuffle(int[] data)
	{
		int ind = 0;
		int temp = 0;
		for(int i = 0; i < data.length; i++)
		{
			ind = i + (int)(Math.random() * ((data.length - 1 - i) + 1));
			temp = data[i];
			data[i] = data[ind];
			data[ind] = temp;	
		}
	}

}
