/* File Name: RaymondLin_A14.java
*/
import java.util.*;

public class RaymondLin_A14 
{

	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		int A = kbd.nextInt();
		int B = kbd.nextInt();
		int next_term = A - B;
		int cnt = 2;
		
		System.out.print(A + ", " + B);
		
		while(next_term > 0)
		{
			System.out.print(", " + next_term);
			A = B;
			B = next_term;
			next_term = A-B;
			cnt++;
		}
		kbd.close();
		System.out.println("\n" + cnt);
	}
}
	