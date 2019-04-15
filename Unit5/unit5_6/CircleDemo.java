package unit5_6;

import java.text.DecimalFormat;

public class CircleDemo{
		public static void main(String[] args){
			Disk d = new Disk(5,2);
			Disk d1 = new Disk(5,2);
			System.out.println(d.compareTo(d1)); //1 is same, -1 is different.
		}
}

class Circle1 {
	private static final double PI=3.14;
	private double radius;
	DecimalFormat df = new DecimalFormat("#.##"); //formatting to two decimal places

	public Circle1(double givenRadius){
		radius=givenRadius;						//constructs spot with specified radius
	}

	public Circle1(){							//default constructor
		radius=1;
	}

	public void setRadius(double givenRadius){	//mutator method to change radius
		radius=givenRadius;
	}

	public double getRadius(){					//accessor method
			return radius;
	}

	public double area(){						//calculates area of circle with radius
			double circleArea;
			circleArea = PI*radius*radius;
			circleArea = Double.valueOf(df.format(circleArea));
			return(circleArea);
	}

	public double circumference(){				//calculates circumference of circle with radius
				double circleCircum;
				circleCircum=2*PI*radius;
				circleCircum = Double.valueOf(df.format(circleCircum));
				return(circleCircum);
	}

	public String toString() {					//returns string about circle object
		String circleString;
  		circleString = "The radius is " + radius ;
  		return(circleString);
  		}
}
class Disk extends Circle1 implements Comparable
{
	private double thickness;
	
	public Disk(double givenRadius, double thickness){
		super(givenRadius);						//sends givenRadius to constructor of superclass
		this.thickness = thickness;
	}

	public Disk()
	{							//default constructor
		this.setRadius(1);
		thickness = 1;
	}
	public void setThickness(double thickness)
	{
		this.thickness = thickness;
	}
	public double getThickness()
	{
		return thickness;
	}
	public double Volume()
	{
		return Double.valueOf(df.format(super.area()*thickness));
	}
	public String toString()
	{
		String discString;
		discString = "The radius is " + super.getRadius() + ". The thickness is " + thickness + ".";
		return discString;
	}
	public int compareTo(Object obj) {
		final double epsilon = 1.0e-15;

		Disk thisShape = (Disk) obj; 
		
		if ( Math.abs(getRadius() - thisShape.getRadius()) <= epsilon*getRadius() && Math.abs(getThickness() - thisShape.getThickness()) <= epsilon*getThickness())
			return 1;  
		else
			return -1;  
	}
}
