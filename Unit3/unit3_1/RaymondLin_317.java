package unit3_1;

public class RaymondLin_317
{
	public static void main(String[] args) 
	{
		printBottomCorner(4);
	}
	public static void printBottomCorner(int n)
	{
		if(n>0)
		{
			printBottomCorner(n-1);
			for(int i = 0; i < n; i++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
