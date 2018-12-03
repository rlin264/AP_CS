package other;

import java.util.Arrays;

public class RaymondLin_armyFinal {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		
		int n = 1000;
		int cnt = 0;
		int[] data = new int[100];
		for(int j = 0; j < n; j++)
		{
			for(int i = 0; i < data.length;i++)
			{
				data[i] = (int)(Math.random()*2);
			}
			a = getTurns(data);
			b = bubbleSort(data);
			if(a!=b) 
			{
				System.out.println(Arrays.toString(data));
				System.out.println("s "+a);
				System.out.println("b "+b);
				cnt++;
			}
		}
		System.out.println("wrong: " + cnt);
	}
	public static int getTurns(int[] army)
	{
		int pos = 0;
		int steps = 0;
		int gapOfOnes = 0;
		int numOnes = 0;
		int relOnes = 0;
		int wait = 0;
		int lastWait = 0;
		int lastSteps = 0;
		int prev_zero = 0;
		boolean has_zero = false;
		while(army[pos] == 0) //ignore leading zeroes.
		{
			pos++;
			if(pos == army.length) return 0;
		}
		prev_zero = pos;
		while(pos < army.length)
		{
			if(army[pos] == 1)
			{
				numOnes++;
			}
			if(army[pos] == 0)
			{
				gapOfOnes = pos-prev_zero-1;
				if(!has_zero)
				{
					steps = numOnes;
					has_zero = true;
					prev_zero = pos;
				}
				else
				{
					if(army[pos-1] == 0) wait++;
					if(gapOfOnes <= lastWait) steps = lastSteps+1;
					else steps = numOnes;
					if(steps < numOnes) steps = numOnes;
				}
//				System.out.println(pos + " " + Arrays.toString(army) + army[pos]);
//				System.out.println("pzero " + prev_zero);
//				System.out.println("numOnes " + numOnes);
//				System.out.println("gapOnes " + gapOfOnes);
//				System.out.println("wait " + wait);
//				System.out.println("lastWait " + lastWait);
//				System.out.println("steps " + steps);
//				System.out.println("lastSteps " + lastSteps);
				prev_zero = pos;
				lastSteps = steps;
				lastWait = wait;
			}
			pos++;
		}
		
		return steps;
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
	public static int bubbleSort(int[] army)
	{
		//modify bubble sort
		int[] data = new int[army.length];
		for(int i = 0; i < army.length; i++)
		{
			data[i] = army[i];
		}
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
