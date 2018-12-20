package unit3_1;

public class RaymondLin_318
{
	public static void main(String[] args) 
	{
		printTopCorner(4);
	}
	public static void printTopCorner(int n)
	{
		if(n>0)
		{
			for(int i = 0; i < n; i++)
			{
				System.out.print("*");
			}
			System.out.println("");
			printTopCorner(n-1);
		}
	}
}
