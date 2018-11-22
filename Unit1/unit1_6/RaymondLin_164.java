package unit1_6;
/*File Name: RaymondLin_164.java
 * 
 */

import java.util.*;

public class RaymondLin_164 
{

	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		double A = kbd.nextDouble();
		int N = kbd.nextInt();
		
		double next = 1/A;
		double recip_sum = 0;
		System.out.println(A);
		System.out.println(next);
		
		for(int i = 0; i < N; i++)
		{
			recip_sum += 1/next;
			next = recip_sum;
			System.out.println(recip_sum);
		}
		kbd.close();
	}

}
