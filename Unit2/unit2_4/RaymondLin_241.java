package unit2_4;

import java.util.*;
public class RaymondLin_241 
{
	public static void main(String[] args)
	{
		String title = "Chez ICS";
		String[] items = new String[]{"tranquility", "walk", "java", "holy smoke"};
		menu(title, items);
	}
	public static int menu(String title, String[] items)
	{
		Scanner kbd = new Scanner(System.in);
		System.out.println(title);
		for(int i = 1; i <= items.length; i++)
		{
			System.out.println(i + " " + items[i-1]);
		}
		System.out.print("Enter a number from the menu: ");
		int n = kbd.nextInt();
		kbd.close();
		if(n > items.length)
		{
			return -1;
		}
		return n-1;
	}
}
