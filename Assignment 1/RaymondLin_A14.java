/* File Name: RaymondLin_A14.java
 * A program takes in inputs A and B.
 * There is a sequence defined as T(1) = A, T(2) - B, T(n) = T(n-2) - T(n-1) for n > 2
 * The sequence must be non increasing and positive except for the last term which must 
 * be larger than the second last.
 * This program prints all elements of the sequence and the number of terms
*/
import java.util.*;

public class RaymondLin_A14 
{

	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int A = kbd.nextInt();  //the first term
		int B = kbd.nextInt();  //the second term
		int next_term = A - B;  //the next term
		int cnt = 2;			//the number of terms in the sequence which starts at 2
		
		System.out.print(A + ", " + B); //prints the first two terms without a newline
		
		while(next_term > 0)//loop until next term is negative
		{
			System.out.print(", " + next_term); //prints the next term
			A = B;								//sets A to be which is term n-2
			B = next_term;						//sets B to next_term which is term n-1
			next_term = A-B;					//sets next_term to A-B as defined by the seqeunce
			cnt++;
		}
		kbd.close();
		System.out.println("\n" + cnt); //print out the number of terms
	}
}
	