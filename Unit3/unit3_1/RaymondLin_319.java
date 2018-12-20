package unit3_1;

public class RaymondLin_319
{
	public static void main(String[] args) 
	{
		System.out.println(isPower(626,5));
	}
	public static boolean isPower(int n, int base)
	{
		if(base == n) return true;
		else if(base < n)
		{
			return isPower(n,base*base);
		}
		return false;
	}
}
