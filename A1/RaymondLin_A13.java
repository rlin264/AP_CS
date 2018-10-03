/* File Name: RaymondLin_A13.java
 * This program reads two positive integers D (D < 8), and Z and prints the number of all D-digit
 * positive integers N such that N(N-1) ends with Z zeros exactly. 
*/
import java.util.*;

public class RaymondLin_A13 {

	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int D = kbd.nextInt();
		int Z = kbd.nextInt();
		int N = 0;
		int prod = 0;
		int one = 0; //ones digit of a D-digit number
		int cnt = 0;
		boolean has_zeros = true;
		
		
		int low = 1;
		for(int i = 1; i < D; i++)
		{
			low = low*10;
		}
		int high = low*10;
		
		
		for(int i = low; i < high; i++)
		{
			N = i;
			one = N%10;
			if(one == 0 || one == 1 || one == 5 || one == 6)
			{
				has_zeros = true;
				prod = N*(N-1);
				for(int j = 0; j < Z; j++)
				{
					if(prod%10 != 0)
					{
						has_zeros = false;
					}
					prod = prod/10;
				}
				if(has_zeros) cnt++;
				
			}
		}
		System.out.println(cnt);
		kbd.close();

	}

}
