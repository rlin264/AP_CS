package unit2_1;
/*File Name: RaymondLin_211
This program finds the number of times the first, last and another number appear in a sequence.
 */

import java.util.*;

public class RaymondLin_211
{	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int N = kbd.nextInt();
		int A = kbd.nextInt();
		int B = kbd.nextInt();
		int[] arr = new int[N];
		int other = 0;
		int other_cnt = 0;
		int first_cnt = 0;
		int last_cnt = 0;
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = A + (int)(Math.random() * ((B - A) + 1));
		}
		
		for(int i = 0; i < N; i++)
		{
			if(arr[i] == arr[0]) first_cnt++;
			if(arr[i] == arr[N-1]) last_cnt++;
		}
		
		for(int i = 0; i < N; i++){
			if(arr[i] != arr[0] && arr[i] != arr[N-1])
			{
				other = arr[i];
				break;
			}
		}
		for(int i = 0; i < N; i++){
			if(arr[i] == other) other_cnt++;
		}
		
		System.out.println(arr[0] + ":" + first_cnt);
		System.out.println(arr[N-1] + ":" + last_cnt);
		System.out.println(other + ":" + other_cnt);
		
		kbd.close();
		
		

	}

}
