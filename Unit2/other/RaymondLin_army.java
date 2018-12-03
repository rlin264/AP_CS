package other;
import java.util.*;

public class RaymondLin_army 
{

	public static void main(String[] args) 
	{
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
			try 
			{
				a = getTurns5(data);
				b = bubbleSort(data);
				if(a!=b) 
				{
					System.out.println(Arrays.toString(data));
					System.out.println("s "+a);
					System.out.println("b "+b);
					cnt++;
				}
			}
			catch(Exception e) 
			{
				System.out.println(Arrays.toString(data));
				break;
			}
			
		}
		System.out.println(cnt);
		
//		int[] data1 = new int[] {1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0};
//		a = getTurns5(data1);
//		b = bubbleSort(data1);
//		System.out.println(Arrays.toString(data1));
//		System.out.println("s "+a);
//		System.out.println("b "+b);
		

	}
	public static int getTurns5(int[] army)
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
	public static int getTurns4(int[] army)
	{
		int pos = 0;
		int steps = 0;
		int gapOfOnes = 0;
		int numOnes = 0;
		int wait = 0;
		int lastWait = 0;
		int lastSteps = 0;
		int prev_zero = 0;
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
				if(army[pos-1] == 0) //consecutive ones. change to if zero is to the right of any zeros
				{
					wait++;
				}
				else
				{
					lastWait = wait;
					wait = 0;
					steps = numOnes;
				}
				if(gapOfOnes <= lastWait) steps = lastSteps+1;
				prev_zero = pos;
				System.out.println(pos + " " + Arrays.toString(army) + army[pos]);
				System.out.println("numOnes " + numOnes);
				System.out.println("gapOnes " + gapOfOnes);
				System.out.println("wait " + wait);
				System.out.println("lastWait " + lastWait);
				System.out.println("steps " + steps);
				System.out.println("lastSteps " + lastSteps);
				lastSteps = steps;
			}
			pos++;
		}
		
		return steps;
	}
	public static int getTurns3(int[] army)
	{
		int pos = 0;
		int zeroes = 0;
		int ones = 0;
		int n_ones = 0;
		int turns = 0;
		while(army[pos] == 0) //ignore leading zeroes.
		{
			pos++;
			if(pos == army.length) return 0;
		}
		while(army[pos] == 1) //count the first ones following the leading zeroes.
		{
			n_ones++;
			pos++;
			if(pos == army.length) return 0; //one sequence of zeroes followed by ones.
		}
		while(pos < army.length)
		{
			zeroes = 0;
			ones = 0;
			while(pos < army.length && army[pos] == 0)//count consecutive zeroes
			{
				zeroes++;
				pos++;
			}
			while(pos < army.length && army[pos] == 1)//count consecutive zeroes
			{
				ones++;
				n_ones++;
				pos++;
			}
			if(zeroes > ones && ones > 0 && pos != army.length)
			{
				turns += zeroes - ones;
			}
		}
		System.out.println("turns " + turns);
		System.out.println("n_ones " + n_ones);
		System.out.println("ones " + ones);
		System.out.println("zeroes " + zeroes);
		pos--;
		turns += (n_ones - ones) + zeroes - 1;
		return turns;
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
				//System.out.println("ones" + consec_ones);
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
					if(consec_ones <= consec_zeroes - 1 ) {
						System.out.println("ASD");
						c++; //dunno about this...
					}
					System.out.println("zeroes" + consec_zeroes);
					consec_zeroes = 0;
				}
				else consec_zeroes++;
			}
		}
		System.out.println(Arrays.toString(army));
		n = ind2-ind1+1;
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