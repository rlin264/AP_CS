/*File Name: RaymondLin_215
This program prints out the sum of the indices of elements that are larger than the sum of all the elements.
 */

import java.util.*;

public class RaymondLin_215
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int size = kbd.nextInt();
		int[] arr = new int[size];
		int sum = 0;
		int sum_indices = 0;
		int element_exists = -1;
		
		for(int i = 0; i < size; i++)
		{
			arr[i] = kbd.nextInt();
			sum += arr[i];
		}
		kbd.close();
		for(int i = 0; i < size; i++)
		{
			if(arr[i] > sum)
			{
				sum_indices += i;
				element_exists = 1;
			}
		}
		if(element_exists == 1) System.out.println(sum_indices);
		else System.out.println(-1);
	}

}
