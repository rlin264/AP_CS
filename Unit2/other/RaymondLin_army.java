package other;

import java.util.*;

public class RaymondLin_army 
{

	public static void main(String[] args) 
	{
		int[] data = new int[10];
		for(int i = 0; i < data.length;i++)
		{
			data[i] = (int)(Math.random()*2);
		}
		System.out.println(Arrays.toString(data));
		System.out.println(getTurns(data));
		System.out.println(bubbleSort(data));

	}
	public static int getTurns(int[] army) 
	{
		int cnt1 = 0;
		int cnt2 = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		for(int i = 0; i < army.length; i++) 
		{
			if(flag1 = true)
			{
				if(army[i] == 0)
				{
					cnt1++;
				}
			}
			else
			{
				if(army[i] == 1)
				{
					flag1 = true;
				}
			}
			if(flag2 = true)
			{
				if(army[army.length-i-1] == 1)
				{
					cnt2++;
				}
			}
			else
			{
				if(army[army.length-i-1] == 0)
				{
					flag2 = true;
				}
			}
		}
		return Math.max(cnt1, 0);
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
		int cnt = 0;
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
			cnt++;
		}
		return cnt-1;
	}
}
