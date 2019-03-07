package classes1;

public class TestCircle 
{
	public static void main(String[] args)
	{
		Circle spot = new Circle(5);
		System.out.println("Circle Radius: " + spot.getRadius());
		System.out.println("Circle Area: " + spot.area());
		System.out.println("Circle Circumference: " +spot.circumference());
		Circle.displayAreaFormula();
		Circle.displayCircumferenceFormula();
	}
}

class Circle 
{
	private static final double PI = 3.14;
	private double radius;
	
	public Circle(double radius)
	{
		this.radius = radius;
	}
	public double getRadius()
	{
		return(radius);
	}
	public double area()
	{
		return(PI*radius*radius);
	}
	public double circumference()
	{
		return(2*PI*radius);
	}
	public static void displayAreaFormula()
	{
		System.out.println("Area = \u03C0R\u00B2");
	}
	public static void displayCircumferenceFormula()
	{
		System.out.println("Circumference = 2\u03C0R");
	}
}	

