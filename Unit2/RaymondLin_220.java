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
		int size = 3;//kbd.nextInt();
		int[] arr = new int[10];
		//int[] arr2 = new int[4];
		int lower = -5;
		int upper = 5;
		//create array
		randomize(arr, lower, upper);
		//randomize(arr2, lower, upper);
		System.out.println(Arrays.toString(arr));
		//shuffle(arr);
		//reverse(arr);
		//shift(arr,3);
		//split(arr);
		bubbleSort(arr);
		//sortDigits(arr);
		//sortDigits(arr2);
		//selectionSort(arr);
		//insertionSort(arr);
		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr2));
//		int[] c = merge(arr, arr2);
//		System.out.println(Arrays.toString(c));
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
	//225
	public static void split(int[] data)
	{
		int left = 0;
		int right = data.length - 1;
		while(left < right)
		{
			if(data[left] < 0)
			{
				left++;
			}
			else
			{
				swap(data,left,right);
				right--;
			}
		}
	}
	//226
	public static void bubbleSort(int[] data)
	{
		boolean sorted = false;
		int sorted_i = data.length-1;
		while(!sorted)
		{
			sorted = true;
			for(int i = 0; i < sorted_i; i++)
			{
				if(data[i] > data[i+1])
				{
					swap(data, i, i+1);
					sorted = false;
				}
			}
			sorted_i--;
		}
	}
	//227
	public static void sortDigits(int[] data)
	{
		if(data == null || data.length < 2) return;
		/* create array size 10
		 * read a digit. If 1 increase number of index 1 in second array by one etc.
		 */
		int digits[] = new int[10];
		for(int i = 0;i < data.length; i++)
		{
			digits[data[i]]++;
		}
		int ind = 0;
		for(int i = 0;i < digits.length; i++)
		{
			for(int j = 0; j < digits[i]; j++)
			{
				data[ind] = i;
				ind++;
			}
		}
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
	//2210
	public static int[] merge(int[] a, int[] b)
	{
		int[] c = new int[a.length + b.length];
		int ia = 0;
		int ib = 0;
		int ic = 0;
		while(ia < a.length && ib < b.length)
		{
			if(a[ia] < b[ib])
			{
				c[ic] = a[ia];
				ia++;
			}
			else
			{
				c[ic] = b[ib];
				ib++;
			}
			ic++;
		}
		System.out.println(ia + " " + ib);
//		while(ia<a.length)
//		{
//			c[ic] = a[ia];
//			ia++;
//			ic++;
//		}
//		while(ib<b.length)
//		{
//			c[ic] = b[ib];
//			ib++;
//			ic++;
//		}
		for(int i = ia; i < a.length; i++)
		{
			c[ic] = a[i];
			ic++;
		}
		for(int i = ib; i < b.length; i++)
		{
			c[ic] = b[i];
			ic++;
		}
		
		return c;
	}

}
