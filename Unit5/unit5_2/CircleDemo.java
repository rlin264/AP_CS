package unit5_2;

import java.text.DecimalFormat;

public class CircleDemo{
		public static void main(String[] args){
			Puck p = new Puck(5,2,5);			//construct with radius of 5
			System.out.println(p.toString());
		}
}

class Circle {
	private static final double PI=3.14;
	private double radius;
	DecimalFormat df = new DecimalFormat("#.##"); //formatting to two decimal places

	public Circle(double givenRadius){
		radius=givenRadius;						//constructs spot with specified radius
	}

	public Circle(){							//default constructor
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
class Disk extends Circle
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
}
class Puck extends Disk
{
	private boolean standard;
	private boolean youth;
	private double weight;
	public Puck(double radius, double thickness, double weight)
	{
		super(radius,thickness);
		this.weight = weight;
	}
	public double getWeight()
	{
		return weight;
	}
	public String getDivision()
	{
		if(weight <= 5.5 && weight >= 5.0)
		{
			standard = true;
			youth = false;
			return "Standard";
		}
		else if(weight <= 4.5 && weight >= 4.5)
		{
			standard = false;
			youth = true;
			return "Youth";
		}
		else return "Neither";
	}
	public String toString()
	{
		String puckString;
		puckString = "The radius is " + super.getRadius() 
			+ ". \nThe thickness is " + super.getThickness()
			+ ".\nThe volume is " + super.Volume()
			+ "." + "\nStandard or Youth: " + this.getDivision();
		return puckString;
	}
}
