/*File Name: RaymondLin_223
This program has a function that reverses an array
 */

import java.util.*;

public class RaymondLin_223
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int[] arr = new int[]{1,2,3,4,5};
		reverse(arr);
		System.out.println(Arrays.toString(arr));
		kbd.close();
		
	}
	public static void reverse(int[] data)
	{
		int temp = 0;
		for(int i = 0; i < data.length/2; i++)
		{
			temp = data[i];
			data[i] = data[data.length-i-1];
			data[data.length-i-1] = temp;
		}
	}

}
