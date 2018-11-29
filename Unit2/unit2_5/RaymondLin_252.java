package unit2_5;

public class RaymondLin_252 
{
	public static void main(String[] args)
	{
		System.out.println(mostOften("toronto"));
	}
	public static char mostOften(String str)
	{
		char a = str.charAt(0);	
		return a;
	}
}

/*
 * Imagine an army. Huge army
 * Army is lined up in one line
 * General yells turn. Everyone turns randomly either left or right.
 * General yells march. If two soldiers are facing each other, they both turn away. 1 turn per second.
 * Can the army move? When can the army move? (all right; all left; one part left one part right)
 * Why?
 * How many seconds to make first step?
 * Input: First line: n number of soldiers. second line: positions of soldiers. (0 is left, 1 is right).
 * Output: Time in seconds to turn, if possible.
 * Condition: single pass algorithm. Ideally no array.
 */