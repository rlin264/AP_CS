package unit1_4;
/*File: RaymondLin_144.java
This program finds whether a point (X,Y) is located within a parabola Ax^2 + Bx + C
*/
import java.util.*;

public class RaymondLin_144
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("A: ");
		double A = sc.nextDouble();
		System.out.print("B: ");
		double B = sc.nextDouble();
		System.out.print("C: ");
		double C = sc.nextDouble();
		System.out.print("X: ");
		double X = sc.nextDouble();
		System.out.print("Y: ");
		double Y = sc.nextDouble();
		int ans = 0;

		double y = A*X*X + B*X + C;
		System.out.println(y);

		if(A > 0)
		{
			if(y <= Y)
			{
				ans = 1;
			}
		}
		else
		{
			if(Y <= y)
			{
				ans = 1;
			}
		}
		sc.close();
		System.out.println(ans);
	}
}