package unit3_1;

public class RaymondLin_314 
{
	public static void main(String[] args) 
	{
		System.out.println(digitalRoot(12599));
	}
	public static double digitalRoot(int n)
	{
		int a = digitSum(n);
		if(a/10 == 0) return a;
		return digitalRoot(a);
	}
	public static int digitSum(int n)
	{
		if(n/10 == 0) return n;
		return n%10 + digitSum(n/10);
	}
}
