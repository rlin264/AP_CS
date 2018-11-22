package unit2_3;
//import java.util.*;

public class RaymondLin_231 {

	public static void main(String[] args) 
	{
		int[][] matrix = new int[6][10];
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[row].length; col++)
			{
				matrix[row][col] = (int)(Math.random()*10);
			}
		}
		print(matrix);
 	}
	
	public static void print(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
//				System.out.print(matrix[i][j] + " ");
				System.out.printf("%6d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.print("\n\n");
	}

}
