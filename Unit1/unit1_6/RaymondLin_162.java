package unit1_6;
/*File Name: RaymondLin_162.java
 * 
 */

import java.util.*;

public class RaymondLin_162 
{

	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int N = kbd.nextInt();
		kbd.close();
		int prod = 1;
		for(int i = 1; i < N; i++)
		{
			System.out.println(prod);
			prod = prod * (i+1);
		}
		System.out.println(prod);
	}

}
