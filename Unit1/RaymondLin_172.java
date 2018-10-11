/*File Name: RaymondLin_172
 * If a triangle with side lengths a, b, c exists, the solve the area using Heron's formula
 */

import java.util.*;

public class RaymondLin_172 
{
	
	public static double getArea(double a, double b, double c)
	{
		if (a + b < c || a + c < b || b + c < a)
		{
			return -1;
		}
		else
		{
			double s = (a+b+c)/2;
			return Math.sqrt(s*(s-a)*(s-b)*(s-c));
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner kbd = new Scanner(System.in);
		double a = kbd.nextDouble();
		double b = kbd.nextDouble();
		double c = kbd.nextDouble();
		System.out.println(getArea(a, b, c));
		kbd.close();

	}

}
