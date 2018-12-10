package unit2_6;

/*
 * Weather Forecast problem
 * A cell is equal to the average of the four surrounding ones.
 */
public class RaymondLin_261 
{

	public static void main(String[] args) 
	{
		//generate a random 5x5 map
		double[][] map = new double[5][5];
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				map[i][j] = Math.random()*10 + 10; //set of map[row i][col j] to random value from 10 to 20.
			}
		}
		print(map);
		System.out.println("forecast:");
		print(weatherForecast(map));
	}
	public static void print(double[][] map) //prints 2d double array rounded to one decimal
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j<map[i].length; j++)
			{
				System.out.printf("%6.1f", map[i][j]); //prints rounded to one decimal
			}
			System.out.println();
		}
	}
	public static double[][] weatherForecast(double[][] map)
	{
		int rows = map.length;							//# of rows
		int cols = map[0].length;						//# of columns
		double[][] forecast = new double[rows][cols];	//create 2d array forecast with the same size as map
		for(int i = 0; i < rows;i++)					//iterate through all the elements in map
		{
			for(int j = 0; j < cols; j++)
			{
				double sum = 0;				 //sum of the values for the forecast average
				double cnt = 0;				 //number of values being summed
				boolean is_topbottom = false;//whether the element is on the top or bottom edge and not a corner
				boolean is_leftright = false;//whether the element is on the left or right edge and not a corner
				if((i == 0 || i == rows - 1) && !(j == 0 || j == cols - 1)) 	//checks if element is on the top/bottom edge, but not corner
				{
					is_topbottom = true;
				}
				else if((j == 0 || j == cols - 1) && !(i == 0 || i == rows - 1))//checks if element is on the left/right edge, but not corner
				{
					is_leftright = true;
				}
				if(i+1 < rows && !is_topbottom) //increase sum by the below element unless the element is on the top/bottom edge or a corner
				{
					sum += map[i+1][j];
					cnt++;						
				}
				if(j+1 < cols && !is_leftright) //increase sum by the right element unless the element is on the left/right edge or a corner
				{
					sum += map[i][j+1];
					cnt++;
				}
				if(i-1 >= 0 && !is_topbottom) 	//increase sum by the below element unless the element is on the top/bottom edge or a corner
				{
					sum += map[i-1][j];
					cnt++;
				}
				if(j-1 >= 0 && !is_leftright) 	//increase sum by the left element unless the element is on the left/right edge or a corner
				{
					sum += map[i][j-1];
					cnt++;
				}
				forecast[i][j] = sum/cnt;		//calculate forecasted value by dividing sum by number of elements summed
			}
		}
		return forecast;
	}
}
