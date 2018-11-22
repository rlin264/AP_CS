package unit2_1;
/*File Name: RaymondLin_214
This program switches the elements at an even position with the value of the next element if they are both odd or both even.
If the elements in the list is odd, the last element should not be processed
 */

import java.util.*;

public class RaymondLin_214
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int size = kbd.nextInt();
		int[] arr = new int[size];
		int temp = 0;
		
		for(int i = 0; i < size; i++)
		{
			arr[i] = kbd.nextInt();
		}
		kbd.close();
		for(int i = 0; i < size/2; i++)
		{
			if(arr[i*2] % 2 == arr[i*2+1] % 2)
			{
				temp = arr[i*2];
				arr[i*2] = arr[i*2+1];
				arr[i*2+1] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
