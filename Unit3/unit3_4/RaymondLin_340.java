package unit3_4;

import java.util.Arrays;

public class RaymondLin_340 
{
	public static void main(String[] args)
	{
		int[] data = new int[10];
		for(int i = 0; i < data.length; i++)
		{
			data[i] = (int)(Math.random()*20 + 1);
		}
		System.out.println(Arrays.toString(data));
		quickSort(data,0, data.length - 1);
		System.out.println(Arrays.toString(data));
	}
	/* Quick Sort
	 * Choose a pivot in the sequence. All elements to the right are greater than the pivot
	 * All left elements are less than the pivot.
	 * Continue taking partitions on both sides of the original pivot.
	 * Find a new pivot in the new section.
	 */
	public static void quickSort(int[] data, int from, int to)
	{
		if(from < to)
		{
			int pivot = partition(data,from,to);
			quickSort(data, from, pivot-1);
			quickSort(data, pivot+1, to);
		}
	}
	//341
	public static int partition(int[] data, int from, int to)
	{
		int pivot = to; 	//set pivot to last element
		int runner = from;
		
		while(runner < pivot)
		{
			if(data[runner] < data[pivot])
			{
				runner++;
			}
			else
			{
				swap(data, runner, pivot-1);//swap runner and element left of pivot
				swap(data, pivot-1, pivot);	//move pivot to the left
				pivot--;
			}
			System.out.println(Arrays.toString(data));
		}
		return pivot;
		
	}
	public static void swap(int[] data, int a, int b)
	{
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
}
