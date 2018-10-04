/* File Name: RaymondLin_A12.java
 * This programs takes in three integers: n,m,s.
 * There are 2 dices. One has n sides numbered from 1 to n, the others has m sides numbered 1 to m.
 * This program finds the number of ways the numbers rolled on the dies can add to a sum s.
*/
import java.util.*;

public class RaymondLin_A12 {

	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();	//sides of first dice
		int m = kbd.nextInt();	//sides of second dice
		int s = kbd.nextInt();	//number that the sum of the dice rolls should be
		int cnt = 0; 			//number of ways the sum of the integers is s.
		
		for(int i = 1; i <= n; i++) 	//loops through all valid rolls for the first dice
		{
			for(int j = 1; j <= m; j++) //loops through all valid rolls for the second dice
			{
				if(i+j == s) cnt++;		//if the sum of the dice rolls is equal to s, increase cnt.
			}
		}
		System.out.println(cnt);		//print out the number of ways the rolls can add to s
		kbd.close();
	}

}
