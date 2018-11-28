package unit2_4;
import java.util.*;

public class RaymondLin_242 
{
	public static void main(String[] args) 
	{
		String[][] plan = new String[][]{{"a","b","c", "d"},{"e","f","g", "h"},{"i","j","k","l"}};
		System.out.println(Arrays.deepToString(plan));
		shuffle(plan);
		System.out.println(Arrays.deepToString(plan));
	}
	public static void shuffle(String[][] plan)
	{
		for(int i = 0; i < plan.length; i++)
		{
			for(int j = 0; j < plan[i].length; j++)
			{
				int r = (int)(Math.random()*plan.length);
				int c = (int)(Math.random()*plan[i].length);
				String temp = plan[i][j];
				plan[i][j] = plan[r][c];
				plan[r][c] = temp;
			}
		}
	}
	
}
