/*File Name: RaymondLin_212
This file contains all the exercises from 2.2
 */

import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class RaymondLin_220
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int size = 5;//kbd.nextInt();
		int[] arr = new int[size];
		int lower = 1;//kbd.nextInt();
		int upper = 10;//kbd.nextInt();
		//create array
		randomize(arr, lower, upper);
		System.out.println(Arrays.toString(arr));
		//shuffle(arr);
		//reverse(arr);
		//shift(arr,3);
		sortDigits(arr);
		//selectionSort(arr);
		//insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		kbd.close();
	}
	static public void swap ( int [ ] data , int n, int m )
	{
		if ( n >= 0 && n< data.length && m>= 0 && m< data.length )
		{ 
			int tmp = data[ n ] ;
			data [ n ] = data[ m ] ;
			data[ m ] = tmp ;
		}
	}
	//221
	public static void randomize(int[] data, int lower, int upper)
	{
		for(int i = 0; i < data.length; i++)
		{
			data[i] = lower + (int)(Math.random() * ((upper - lower) + 1));
		}
	}
	//222
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
	//223
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
	//224
	public static void shift(int[] data, int n)
	{
		for(int i = 0; i < n; i++)
		{
			int temp = data[data.length-1];
			int previous = 0;
			for(int j = 0; j < data.length; j++)
			{
				previous = data[j];
				data[j] = temp;
				temp = previous;	
			}
		}
	}
	//227
	public static void sortDigits(int[] data)
	{
		if(data == null || data.length < 2) return;
		
		//using another array to sort
	}
	//228
	public static void selectionSort(int[] data)
	{
		if(data == null || data.length < 2) return;
		
		int last = 0;
		int min_ind = 0;
		int min = data[0];
		while(last < data.length)
		{
			min = data[last];
			min_ind = last;
			for(int i = last; i < data.length; i++)
			{
				if(data[i] < min)
				{
					min = data[i];
					min_ind = i;
				}
			}
			swap(data, last,min_ind);
			last++;
		}
	}
	//229
	public static void insertionSort(int[] data)
	{
		if(data == null || data.length < 2) return;
		
		int first = 1;
		while(first<data.length)
		{
			for(int i = first; i > 0 && data[i] <= data[i-1]; i--)
			{
				swap(data,i,i-1);
			}
			first ++;
		}
		
	}

}
