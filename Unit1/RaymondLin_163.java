/*File Name: RaymondLin_163.java
 * 
 */

import java.util.*;

public class RaymondLin_163 
{

	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int N = kbd.nextInt();
		kbd.close();
		int sum = 1;
		for(int i = 1; i < N; i++)
		{
			System.out.println(sum);
			sum = sum + ((i+1)+(i+1)-1);
		}
		System.out.println(sum);
	}

}
