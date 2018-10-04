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
		
		int a = kbd.nextInt(); //user input A
		int b = kbd.nextInt(); //user input B
		int n = kbd.nextInt(); //user input N indicating number of natural numbers
		int num;			   //initialize num which is an element in the sequence
		int cnt = 0;		   //number of elements that satisfy the condition
		
		for(int i = 0; i<n; i++) 	//loop n times to read n elements
		{
			num = kbd.nextInt();	//reads element in sequence	
			if(a<b)					//checks if a < b
			{
				if(num%a == 0 && b%num != 0) //checks if num is a multiple a and not a factor of b
				{
					cnt ++;
				}
			}
			else
			{
				if(num == a+b || num == a*b) //checks if num is equal to the sum or product of a and b
				{
					cnt ++;
				}
			}
		}
		System.out.println(cnt); //print out the number of elements that satisfy the conditions
		kbd.close();
	}
}
