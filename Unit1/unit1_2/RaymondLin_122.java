package unit1_2;
/*File: RaymondLin_122.java
This program finds x^105 using the least amount of operations possible.
*/

public class RaymondLin_122
{
	public static void main(String[] args)
	{
		double x = 1.1; 			//x
		double x2 = x*x; 			//x^2
		double x4 = x2*x2; 			//x^4
		double x8 = x4*x4; 			//x^8
		double x16 = x8*x8; 		//x^16
		double x32 = x16*x16; 		//x^32
		double x35 = x32*x2*x; 		//x^35
		double x105 = x35*x35*x35; 	//x^105
		System.out.println(x105);
	}
}