/* File Name: RaymondLin_A13.java
 * This program reads two positive integers D (D < 8), and Z and prints the number of all D-digit
 * positive integers N such that N(N-1) ends with Z zeros exactly. 
*/
import java.util.*;

public class RaymondLin_A13 {

	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int D = kbd.nextInt();	 	//digits of a positive integer N
		int Z = kbd.nextInt();	 	//number of zeros N*(N-1) should have
		int N = 0;				 	//initialize N
		int prod = 0;			 	//initialize prod which is N(N-1)
		int one = 0; 			 	//ones digit of a D-digit number
		int cnt = 0;			 	//number of D-digit numbers, N, for which N*(N-1) has Z zeros
		boolean has_zeros = true;	//boolean that tells us if N*(N-1) has Z zeros exactly
		
		
		int low = 1;				//lower bound of D-digit numbers N
		for(int i = 1; i < D; i++)	
		{
			low = low*10;			//calculates 10^(D-1) which is the lower bound
		}
		int high = low*10;			//calculates 10^D which is the upper bound
		
		
		for(int i = low; i < high; i++)
		{
			N = i;					//D-digit number N
			one = N%10;				//ones digit of N
			if(one == 0 || one == 1 || one == 5 || one == 6) //Number can only end in zero if ones digit is 0,1,5,6
			{
				has_zeros = true;
				prod = N*(N-1);
				for(int j = 0; j < Z; j++)
				{
					if(prod%10 != 0) //checks if rightmost digit is not zero
					{
						has_zeros = false;
					}
					prod = prod/10; //cuts off rightmost digit
				}
				if(prod%10 == 0) has_zeros = false; //checks if there is an extra zero
				if(has_zeros) cnt++;
				
			}
		}
		System.out.println(cnt); //prints out the count
		kbd.close();

	}

}
