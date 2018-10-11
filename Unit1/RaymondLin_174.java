/*File Name: RaymondLin_174
 * This program finds the factors of a natural number
 */

import java.util.*;

public class RaymondLin_174 
{
	
	public static int countFactors(int a)
	{
		int cnt = 0;
		
		for(int i = 1; i <= (int)Math.sqrt(a); i++)
		{
			if(a%i == 0) cnt ++;
		}			
		cnt = cnt * 2;
		if(a%Math.sqrt(a) == 0) cnt -= 1;
		
		return cnt;
	}
	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int a = kbd.nextInt();
		kbd.close();
		System.out.println(countFactors(a));
	}

}
