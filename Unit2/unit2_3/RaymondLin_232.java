package unit2_3;
import unit2_3.RaymondLin_231;

public class RaymondLin_232 
{
	public static void main(String[] args) 
	{
		int n = (int)(Math.random()*6+1);
		int[][] matrix = new int[n][];
		
		for(int row = 0; row < matrix.length; row++)
		{
			int m = (int)(Math.random()*6+1);
			//int m = row+1;
			matrix[row] = new int[m];
			
			for(int col = 0; col < matrix[row].length; col++)
			{
				matrix[row][col] = (int)(Math.random()*10);
			}
		}	
		RaymondLin_231.print(matrix);
		System.out.println(minmax(matrix));
	}
	public static int max(int data[])
	{
		int max = data[0];
		for(int i = 1; i < data.length; i++)
		{
			if(data[i] > max)
			{
				max = data[i];
			}
		}
		return max;
	}
	public static int minmax(int matrix[][])
	{
		int min = max(matrix[0]);
		int max = 0;
		for(int i = 1; i < matrix.length; i++)
			max = max(matrix[i]);
			if(max < min)
			{
				min = max;
			}
		return min;
	}
}

