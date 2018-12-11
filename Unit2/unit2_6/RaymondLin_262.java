package unit2_6;

import java.util.Arrays;
/* return # of days it will take the virus to infect the entire territory
 * If cannot infect whole territory, return -1.
 * Cell gets infected if it has more than one infected neighbour
 */
public class RaymondLin_262 
{
	public static void main(String[] args)
	{
		//generate a random 5x5 map
		int[][] map = new int[5][5];
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				//sets an element to value 1 if the variable a, a random value from 0 to 9, is greater than 1, else sets it to 0
				int a = (int)(Math.random()*10);
				if(a > 1)map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		//print out the infection map
		for(int i = 0; i < map.length; i++)
		{
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(infectionTest(map));
	}
	public static int infectionTest(int[][] map)
	{
		boolean done_infecting = false; //whether infecting is done
		int cnt; 						//number of adjacent infected cells
		int turns = 0;					//total turns of infections
		int rows = map.length;			//number of rows
		int cols = map[0].length;		//number of columns
		int infections = 0;				//number of infections
		while(!done_infecting)			//loop while there are still infections possible
		{
			infections = 0;				//set infections this turn to zero
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					cnt = 0;
					if(map[i][j] != 0)					      //skip if already infected
					{
						continue;
					}
					if(i+1 < rows && map[i+1][j] != 0) cnt++; //check if below is infected
					if(j+1 < cols && map[i][j+1] != 0) cnt++; //check if to the right is infected
					if(i-1 >= 0 && map[i-1][j] != 0) cnt++;	  //check if above is infected
					if(j-1 >= 0 && map[i][j-1] != 0) cnt++;   //check if to the left is infected
					if(cnt > 1) 						//if there are 2 or more adjacent infected then the element becomes infected
					{
						map[i][j] = turns+2;			//infect map[i][j]
						infections++;					//number of infections
					}
				}
			}
			if(infections == 0) done_infecting = true;	//no infections so done infecting is true
			else turns++;								//increase turns by one
		}
		for(int i = 0; i < rows; i++) //checks if there are any uninfected cells and return -1 if so
		{
			for(int j = 0; j < cols; j++) if(map[i][j] == 0) return -1;
		}
		return turns;
	}
}
