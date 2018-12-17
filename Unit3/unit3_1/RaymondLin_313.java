package unit3_1;

public class RaymondLin_313
{
	public static void main(String[] args) 
	{
		System.out.println(digitSum(123456));
	}
	public static int digitSum(int n)
	{
		if(n/10 == 0) return n;
		return n%10 + digitSum(n/10);
	}
}
