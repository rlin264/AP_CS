/*File Name: RaymondLin_171
 * Prints out if a number is prime
 */

import java.util.*;

public class RaymondLin_171 
{

	public static boolean isPrime(int n)
	{
		if (n== 1 || n == 0) return false;
		
		for(int i = 2; i <= (int)Math.sqrt(n); i++)
		{
			if(n%i == 0) return false;
		}				
		return true;
	}
	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		kbd.close();
		System.out.println("prime: " + isPrime(n));
	}

}
