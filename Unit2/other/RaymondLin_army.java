package other;
import java.util.*;
//n-m
//range of first zero last 1.
//n is the number of elements in the range
//c is the number of sets of ones with length greater than one
//n - c
public class RaymondLin_army 
{

	public static void main(String[] args) 
	{
		int[] data = new int[20];
		for(int i = 0; i < data.length;i++)
		{
			data[i] = (int)(Math.random()*2);
		}
		//int[] data = new int[] {1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
		//System.out.println(Arrays.toString(data));
		//System.out.println(getTurns(data));
		System.out.println("s "+getTurns2(data));
		System.out.println("b "+bubbleSort(data));

	}
	public static int getTurns2(int[] army)
	{
		int n = 0;
		int c = 0;
		int ind1 = 0;
		int ind2 = army.length;
		int consec_ones = 0;
		int consec_zeroes = 0;
		boolean found1 = false;
		boolean found2 = false; //found last zero
		boolean sub = false; //while loop executed or not.
		//first 1, last 0
		for(int i = 0; i < army.length; i++)
		{
			sub = false;
			if(army[i] == 1 && !found1) 
			{
				ind1 = i; 
				//System.out.println("ind1 " + ind1);
				found1 = true;
			}
			if(army[army.length - 1- i] == 0 && !found2) 
			{
				ind2 = army.length - 1- i;
				found2 = true;
			}
			if(found1 && i < army.length)
			{
				consec_ones = 0;
				if(army[i] == 1 && i < ind2) c++;
				while(i < army.length && army[i] == 1)
				{
					sub = true;
					if(army[army.length - 1- i] == 0 && !found2) 
					{
						ind2 = army.length - 1- i;
						found2 = true;
					}
					i++;
					consec_ones++;
				}
				if(sub)
				{
					i--;
					if(consec_ones < consec_zeroes) c++; //dunno about this...
					consec_zeroes = 0;
				}
				else consec_zeroes++;
			}
		}
		System.out.println(Arrays.toString(army));
		System.out.println("c " + c);
		n = ind2-ind1+1;
		System.out.println("ind1 " + ind1 + " ind2 " + ind2);
		System.out.println("n " + n);
		return n-c;
	}
	public static int getTurns(int[] army) 
	{
		int cnt = 0;
		boolean flag = false;
		int consec_zeros = 0;
		for(int i = 0; i < army.length; i++) 
		{
			if(flag = true)
			{
				if(army[i] == 0)
				{
					cnt++;
				}
			}
			else
			{
				if(army[i] == 1)
				{
					flag = true;
				}
			}
		}
		return cnt;
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
	public static int bubbleSort(int[] data)
	{
		//modify bubble sort
		int cnt = 0;
		boolean sorted = false;
		//int sorted_i = data.length-1;
		while(!sorted)
		{
			sorted = true;
			for(int i = 0; i < data.length-1; i++)
			{
				if(data[i] > data[i+1])
				{
					swap(data, i, i+1);
					sorted = false;
					i++;
				}
			}
			//sorted_i--;
			cnt++;
			//System.out.println(Arrays.toString(data));
		}
		return cnt-1;
	}
}
/* test cases:
 * 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0  s 16 b 12
 * 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1  s 9  b 7
 */
/*
 * gap of ones <= last wait
 */