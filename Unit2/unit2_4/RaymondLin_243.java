package unit2_4;

import java.util.Arrays;

public class RaymondLin_243 
{
	public static void main(String[] args) 
	{
		String[] list = new String[]{"a","b","c","d","e","f","g","h","i"};
		System.out.println(Arrays.toString(getSample(list,4)));
	}
	public static String[] getSample(String[] list, int n)
	{
		int[] rand_nums = new int[list.length];
		String[] names = new String[n];
		for(int i = 0; i < list.length; i++)
		{
			rand_nums[i] = i;
		}
		for(int i = 0; i < list.length; i++) //shuffling rand_nums
		{
			int temp = rand_nums[i];
			int m = (int)(Math.random()*(list.length-1));
			rand_nums[i] = rand_nums[m];
			rand_nums[m] = temp;
		}
		for(int i = 0; i < n; i++)
		{
			names[i] = list[rand_nums[i]];
		}
		return names;
	}
}
