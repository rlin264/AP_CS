package unit3_3;

import java.util.Arrays;

public class RaymondLin_330 
{
	public static void main(String[] args)
	{
		int[] data = new int[20];
		for(int i = 0; i < data.length; i++)
		{
			data[i] = (int)(Math.random()*20 + 1);
		}
		System.out.println(Arrays.toString(data));
//		mergeSort(data,0, data.length - 1);
		merge_i(data);
		System.out.println(Arrays.toString(data));
	}

	static void mergeSort(int[] data, int from, int to)
	{
		if(from < to)
		{
			mergeSort(data, from, (from + to)/2);
			mergeSort(data, (from + to)/2+1, to);
			merge(data, from, to);
		}
			
	}
	public static void print(int[] data, int from, int to)
	{
		System.out.println();
		for(int i = from; i < to; i++)
		{
			System.out.printf(" %6d", data[i]);
		}
		System.out.println();
	}
	//332
	public static void merge(int[] data, int from, int to)
	{
		int[] aux = new int[to - from + 1];
		
		for(int i = 0; i < aux.length; i++)
		{
			aux[i] = data[i+from];
		}
		int ia = 0;
		int ib = (aux.length-1)/2 + 1;
		int id = from;
		
		while(ia <= (aux.length-1)/2  && ib < aux.length)
		{
			if(aux[ia] < aux[ib])
			{
				data[id] = aux[ia];
				ia++;
			}
			else
			{
				data[id] = aux[ib];
				ib++;
			}
			id++;
		}
		while(ia <= (aux.length-1)/2)
		{
			data[id] = aux[ia];
			ia++;
			id++;
		}
		//System.out.println(Arrays.toString(data));
	}
	//333
	public static void merge_i(int[] data)
	{
		for(int groupSize = 1; groupSize < data.length; groupSize *= 2)
		{
			for(int n = 0; n < data.length; n+=groupSize)	//n is position of first element in section to be merged
			{
				merge(data, n, n+groupSize);
			}
		}
	}
}
