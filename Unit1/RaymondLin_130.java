/* File RaymondLin_130.java
This program calculates and prints out the BMI of a person, given the person’s weight, in kg, and height, in cm.
The value of BMI is rounded to the nearest tenth, using arithmetical operations and casting only.
*/

import java.util.*;

public class RaymondLin_130
{
	static public void main( String[] args )
	{
		Scanner kbd = new Scanner( System.in ); // the variable kbd is associated with the standard input
		String name = ""; // the name of a person
		int weight = 0; // the weight of the person
		double height = 0.0; // the height of the person
		double bmi = 0.0; // the BMI of the person
		System.out.print("\nEnter your name -> ");

		name = kbd.next();
		System.out.print("\nEnter your weight, in whole kg (e.g. 65) ->  ");
		weight = kbd.nextInt();
		System.out.print("Enter your height, in m and cm (e.g. 1.75) -> ");
		height = kbd.nextDouble();
		bmi = weight / (height * height); // calculating the BMI
		bmi = (int) ( (bmi + 0.5)*10 ) / 10.0; // rounding to the nearest tenth
		System.out.println("\nDear " + name + "." );
		System.out.println("Your BMI is equal to " + bmi );
		kbd.close();
	}
}