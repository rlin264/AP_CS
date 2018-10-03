/* File Name: RaymondLin_A11.java
 * This program reads three natural numbers A, B and N followed by a sequence of N natural numbers
 * If A < B, the program prints the number of elements that are multiples of A and not factors of B
 * Else, the program prints the number of terms equal to either A+B or A*B.
*/
import java.util.*;

public class RaymondLin_A11 
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int a = kbd.nextInt();
		int b = kbd.nextInt();
		int n = kbd.nextInt();
		int num;
		int cnt = 0;
		
		for(int i = 0; i<n; i++)
		{
			num = kbd.nextInt();
			if(a<b)
			{
				if(num%a == 0 && b%num != 0)
				{
					cnt ++;
				}
			}
			else
			{
				if(num == a+b || num == a*b)
				{
					cnt ++;
				}
			}
		}
		System.out.println(cnt);
		kbd.close();
	}
}
