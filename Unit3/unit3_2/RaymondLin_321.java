package unit3_2;

public class RaymondLin_321 
{
	public static void main(String[] args) 
	{
		final long startTime = System.nanoTime();
		System.out.println(power(1.0005,5000));
		final long endTime = System.nanoTime();
		System.out.println("Total execution time: " + (endTime - startTime));
	}
	public static double power(double x, long n)
	{
		if(n==1) return x;
		double a = power(x,n/2);
		if(n%2 == 0)
		{
			return a*a;
		}
		return x*a*a;
	}
	public static double power1(double x, long n)
	{
		if(n==1) return x;
		if(n%2 == 0)
		{
			return power1(x*x, n/2);
		}
		return x*power1(x,n-1);
	}
}