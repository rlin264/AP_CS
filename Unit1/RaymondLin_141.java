/*File RaymondLin_141.java
This program finds whether a point (X,Y) is located within a circle defined as x^2 + y^2 = R^2
*/
import java.util.*;

public class RaymondLin_141
{
	
		public static void main(String[] args)
		{
			Scanner sc = new Scanner(System.in);

			System.out.print("X: ");
			double X = sc.nextDouble(); //x coordinate of a point
			System.out.print("Y: ");
			double Y = sc.nextDouble(); //y coordinate of a point
			System.out.print("R: ");
			double R = sc.nextDouble(); //radius of a circle

			if((X*X + Y*Y) <= R*R)		//compute whether point is within a circle using Pythagorean theorem
			{
				System.out.println("Within");
			}
			else
			{
				System.out.println("Beyond");
			}
			sc.close();
	}
}