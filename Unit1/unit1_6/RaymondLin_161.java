package unit1_6;
/*File Name: RaymondLin_161.java
 * 
 */

import java.util.*;

public class RaymondLin_161 
{

	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int N = kbd.nextInt();
		kbd.close();
		double sum = 0;
		double sign = 1;
		for(double i = 1; i <= N; i++)
		{
			sum += 1/i * sign;
			sign = sign * -1;
		}
		
		System.out.println(sum);
		
		
		
	}

}
