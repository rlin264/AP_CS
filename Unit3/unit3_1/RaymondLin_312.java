package unit3_1;

public class RaymondLin_312 
{
	public static void main(String[] args) 
	{
		System.out.println(sumGeom(2,2,4));
	}
	public static double sumGeom(double term, double ratio, int n)
	{
		if(n == 1) return term;
		return term + ratio*sumGeom(term, ratio, n-1);
	}
}
