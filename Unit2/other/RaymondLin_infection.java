package other;

import java.util.Arrays;

public class RaymondLin_infection 
{
	public static void main(String[] args)
	{
		int[][] map = new int[5][5];
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				int a = (int)(Math.random()*5);
				if(a > 1)map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
//		int[][] map = new int[][]{{0,0,0},{1,1,0},{1,0,0}};
		for(int i = 0; i < map.length; i++)
		{
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(infectionTest(map));
	}
	public static int infectionTest(int[][] map)
	{
		/*# of days it will take the virus to infect the entire territory
		 * If cannot infect whole territory, return -1.
		 * Cell gets infected if it has more than one infected neighbour
		 */
		boolean done_infecting = false;
		boolean has_zeros = false; //scenario when there are still zeros at the end.
		int cnt;
		int turns = 0;
		int rows = map.length;
		int cols = map[0].length;
		int infections = 0;
		while(!done_infecting)
		{
			done_infecting = false;
			infections = 0;
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					cnt = 0;
					if(map[i][j] != 0) continue;
					if(i+1 < rows && map[i+1][j] != 0) cnt++;
					if(j+1 < cols && map[i][j+1] != 0) cnt++;
					if(i-1 >= 0 && map[i-1][j] != 0) cnt++;
					if(j-1 >= 0 && map[i][j-1] != 0) cnt++;
					if(cnt > 1) 
					{
						map[i][j] = turns+2;
						infections++;
					}
				}
			}
			if(infections == 0) done_infecting = true;
			else turns++;
			System.out.println();
			for(int i = 0; i < map.length; i++)
			{
				System.out.println(Arrays.toString(map[i]));
			}
		}
		return turns;
	}
}
