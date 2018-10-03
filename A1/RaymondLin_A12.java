/* File Name: RaymondLin_A12.java
 * This programs takes in three integers: n,m,s.
 * The program prints out the number of ways a number from 1 to m can be added
 * to a number from 1 to n to equal s.
*/
import java.util.*;

public class RaymondLin_A12 {

	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int m = kbd.nextInt();
		int s = kbd.nextInt();
		int cnt = 0; //number of ways the sum of the integers is s.
		
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= m; j++)
			{
				if(i+j == s) cnt++;
			}
		}
		System.out.println(cnt);
		kbd.close();
	}

}
