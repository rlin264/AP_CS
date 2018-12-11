package unit2_6;

import java.util.Arrays;

/* File: RaymondLin_264.java
 * Classroom has N lights. Every K-th second the K-th light is checked and if it is on
 * switch the K+1-th light to the opposite position.
 * Return the time needed in seconds to switch on all the lights
 */

public class RaymondLin_264 
{
	public static void main(String[] args) 
	{
		int[] lights = new int[10];	
		for(int i = 0; i < lights.length; i++)
		{
			lights[i] = (int)(Math.random()*2);		//random number from 0 to 1
		}
		lights[(int)(Math.random()*10)] = 1; 		//guarantee one light is on
		System.out.println(Arrays.toString(lights));
		System.out.println(light(lights));
	}
	public static int light(int[] lights)
	{
		int time = 0;			//time in seconds
		boolean all_on = false; //if all lights are on
		while(!all_on)			//loop while lights are off
		{
			all_on = true;
			for(int i = 0; i < lights.length; i++) //checks if any light is off
			{
				if(lights[i] == 0) 
				{
					all_on = false;
					break;
				}
			}
			if(all_on) break;
			if(lights[time%lights.length] == 1) //if the light is on
			{
				if(lights[(time+1)%lights.length] == 1) lights[(time+1)%lights.length] = 0;	//if K+1-th light is on, turn it off
				else lights[(time+1)%lights.length] = 1;									//if K+1-th light is off, turn it on
			}
			//System.out.println(turns + " " + " " + turns%lights.length + Arrays.toString(lights));
			time++;
		}
		return time;
	}

}
