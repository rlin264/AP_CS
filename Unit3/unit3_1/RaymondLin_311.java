package unit3_1;

public class RaymondLin_311 
{
	public static void main(String[] args) 
	{
		System.out.println(termArithm(1,2,5));
	}
	public static double termArithm(double term, double diff, int n)
	{
		if(n == 0) return term;
		return diff + termArithm(term, diff, n-1);
	}
}
