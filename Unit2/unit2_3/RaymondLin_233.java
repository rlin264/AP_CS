package unit2_3;
import unit2_3.RaymondLin_231;

public class RaymondLin_233 
{
	public static void main(String[] args) 
	{
		int n = (int)(Math.random()*6+2);
		int[][] matrix = new int[n][n];
		crosses(matrix);
		RaymondLin_231.print(matrix);
	}
	public static void crosses(int[][] matrix)
	{
		int c = 0;
		for(int row = 0; row < matrix.length/2+1; row++)
		{
				matrix[row][c] = 1;
				matrix[row][matrix[row].length - c- 1] = 1;
				matrix[matrix.length - row - 1][matrix[row].length - c- 1] = 1;
				matrix[matrix.length - row - 1][c] = 1;
				c++;
		}
	}
}
