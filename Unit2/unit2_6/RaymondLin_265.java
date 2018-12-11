package unit2_6;

/* File: RaymondLin_265.java
 * The standard input contains a sequence of integers from 1 to N inclusive with exception for 
 * exactly one number from the range. Both the number of integers in the sequence and the value
 * of N are unknown. Sequence ends with 0. The task is to find the missing integer in a single pass.
 */

import java.util.*;

public class RaymondLin_265 
{
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int cnt = 1;			//the value n should be
		int n = kbd.nextInt();
		while(n != 0) 			//iterate until n is 0
		{
			if(n != cnt)		//checks if n is correct
			{
				break;
			}
			cnt++;				//increase the supposed value of n by 1
			n = kbd.nextInt();  //get next number in sequence
		}
		kbd.close();
		System.out.print(cnt);  //output missing integer
	}

}
