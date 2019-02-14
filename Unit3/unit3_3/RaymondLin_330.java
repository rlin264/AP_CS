package unit3_3;

import java.util.Arrays;

public class RaymondLin_330 
{
	public static void main(String[] args)
	{
		int[] data = new int[5];
		for(int i = 0; i < data.length; i++)
		{
			data[i] = (int)(Math.random()*20 + 1);
		}
//		System.out.println(Arrays.toString(data));
////		mergeSort(data,0, data.length - 1);
//		mergeSort_i(data);
//		System.out.println("ASDSA");
//		System.out.println(Arrays.toString(data));
		
		int[] data1 = new int[] {6,7,10,15,8};
		merge(data1,0,4);
		System.out.println(Arrays.toString(data1));
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
		if(from > to)
		{
			return;
		}
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
		System.out.println(ib);
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
			//System.out.println("ia " + ia + " ib " + ib + " id " + id);
		}
		while(ia <= (aux.length-1)/2)
		{
			data[id] = aux[ia];
			ia++;
			id++;
		}
		while(ib < aux.length)
		{
			data[id] = aux[ib];
			ib++;
			id++;
		}
	}
	//333
	public static void mergeSort_i(int[] data)
	{
		for(int groupSize = 1; groupSize <= data.length-1; groupSize *= 2)
		{
			for(int n = 0; n < data.length; n+=(groupSize*2))	//n is position of first element in section to be merged
			{													//groupSize*2 is the actual group size
				
				merge(data, n, Math.min(n+groupSize*2-1, data.length-1));
				System.out.println(n + " " + groupSize*2 + Arrays.toString(data));
			}
		}
		merge(data, 0, 4);
		
	}
}
