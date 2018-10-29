/*File Name: RaymondLin_216
This program prints out the sum of the indices of elements that are larger than the sum of all the elements.
 */

import java.util.*;

public class RaymondLin_216
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int size = kbd.nextInt();
		double[] arr = new double[size];
		double sum = 0;
		int closest_ind = 0;
		double closest_diff = 0;
		int farthest_ind = 0;
		double farthest_diff = 0;
		
		for(int i = 0; i < size; i++)
		{
			arr[i] = kbd.nextInt();
			sum += arr[i];
		}
		double avg = sum/size;
		closest_diff = Math.abs(arr[0]-avg);
		farthest_diff = Math.abs(arr[0]-avg);
		kbd.close();
		
		for(int i = 1; i < size; i++)
		{
			if(Math.abs(arr[i]-avg) < closest_diff)
			{
				closest_ind = i;
			}
			if(Math.abs(arr[i]-avg) >= farthest_diff)
			{
				farthest_ind = i;
			}
		}
		System.out.println(closest_ind);
		System.out.println(farthest_ind);
	}

}
