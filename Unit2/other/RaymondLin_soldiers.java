package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* Soldiers problem:
 * First line input with an integer giving the number of soldiers
 * Second line contains a string of Ls and Rs (e.g. "RLRLRLRL")
 */
public class RaymondLin_soldiers {

	public static void main(String[] args) throws IOException
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(stdin.readLine());
		String army = stdin.readLine();
		System.out.println(getTurns(army,N));
		
	}
	public static int getTurns(String army, int len)
	{
		int pos = 0;
		int steps = 0;
		int gapOfR = 0;
		int numR = 0;
		int wait = 0;
		int lastWait = 0;
		int lastSteps = 0;
		int prev_L = 0;
		boolean has_L = false;
		while(army.charAt(pos) == 'L') //ignore leading L's.
		{
			pos++;
			if(pos == len) return 0;
		}
		prev_L = pos;
		while(pos < len)
		{
			if(army.charAt(pos) == 'R')
			{
				numR++;
			}
			if(army.charAt(pos) == 'L')
			{
				gapOfR = pos-prev_L-1;
				if(!has_L)
				{
					steps = numR;
					has_L = true;
					prev_L = pos;
				}
				else
				{
					if(army.charAt(pos - 1) == 'L') wait++;
					if(gapOfR <= lastWait) steps = lastSteps+1;
					else steps = numR;
					if(steps < numR) steps = numR;
				}
				prev_L = pos;
				lastSteps = steps;
				lastWait = wait;
			}
			pos++;
		}	
		return steps;
	}
}
