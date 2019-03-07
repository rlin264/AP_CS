package Recursion;

public class Exponent {
	public static void main(String[] args)
	{
		System.out.println(powerOf2(3,4));
	}
	public static int powerOf(int x, int y)
	{
		if(y==1) return x;
		return x*powerOf(x,y-1);
	}
	public static int powerOf2(int x, int y)
	{
		if(y==1) return x;
		int a = powerOf2(x,y/2);
		if(y%2==0) return a*a;	
		return a*a*x;			//equivalent to line 11 from the first function powerOf
	}
}
