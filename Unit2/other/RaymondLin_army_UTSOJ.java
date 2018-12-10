package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RaymondLin_army_UTSOJ {

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
		int gapOfOnes = 0;
		int numOnes = 0;
		int wait = 0;
		int lastWait = 0;
		int lastSteps = 0;
		int prev_zero = 0;
		boolean has_zero = false;
		while(army.charAt(pos) == 'L') //ignore leading zeroes.
		{
			pos++;
			if(pos == len) return 0;
		}
		prev_zero = pos;
		while(pos < len)
		{
			if(army.charAt(pos) == 'R')
			{
				numOnes++;
			}
			if(army.charAt(pos) == 'L')
			{
				gapOfOnes = pos-prev_zero-1;
				if(!has_zero)
				{
					steps = numOnes;
					has_zero = true;
					prev_zero = pos;
				}
				else
				{
					if(army.charAt(pos - 1) == 'L') wait++;
					if(gapOfOnes <= lastWait) steps = lastSteps+1;
					else steps = numOnes;
					if(steps < numOnes) steps = numOnes;
				}
				prev_zero = pos;
				lastSteps = steps;
				lastWait = wait;
			}
			pos++;
		}
		
		return steps;
	}

}
