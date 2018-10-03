/*File: RaymondLin_143.java
This program finds how many roots there are to an equation Ax^2 + Bx + C. It prints -1 if infinite number of roots
*/
import java.util.*;

public class RaymondLin_143
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		double A = sc.nextDouble(); //coefficient of x^2
		double B = sc.nextDouble(); //coefficient of x
		double C = sc.nextDouble(); //constant term

		double D = B*B - 4*A*C; //discriminant

		int numRoots = 0;

		if(A == 0 && B != 0) //checking if equation is linear
		{
			numRoots = 1;
		}
		else if(A == 0 && B == 0) //checking if equation has degree 0
		{
			if(C == 0) //equation is 0 = 0, all values work.
			{
				numRoots = -1;
			}
			else //equation is 0 = n where n != 0. No values work
			{
				numRoots = 0;
			}

		}
		//equation is quadratic check discriminant to find roots
		else if(D == 0) 
		{
			numRoots = 1;
		}
		else if(D > 0)
		{
			numRoots = 2;
		}
		else
		{
			numRoots = 0;
		}

		System.out.println(numRoots);
		sc.close();
	}
}