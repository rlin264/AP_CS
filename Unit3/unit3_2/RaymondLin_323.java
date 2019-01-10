package unit3_2;

public class RaymondLin_323 
{
	public static void main(String[] args)
	{
		int n = 1;
		while(true)
		{
			try 
			{
				factorial(n);
			} 
			catch (StackOverflowError e) 
			{
				System.out.println(n);
				break;
			}	
			n++;
		}
		
	}
	public static int factorial(int n)
	{
		if(n==1) return 1;
		return n*factorial(n-1);
	}
}
