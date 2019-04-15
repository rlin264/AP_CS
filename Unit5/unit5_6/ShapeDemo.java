package unit5_6;

import java.text.DecimalFormat;

interface Comparable {

	 int compareTo(Object obj);

 }

abstract class Shape implements Comparable {
	private String name;

	public Shape (String shapeName){
		name = shapeName;
	}

	public String getName(){
		return name;
	}

	//abstract methods
	public abstract double area();
	public abstract double perimeter();

	//concrete methods
	public double semiPerimeter(){
		return perimeter()/2;
	}

	public int compareTo(Object obj){

		final double epsilon = 1.0e-15; //a number slightly bigger than machine precision

		Shape thisShape = (Shape) obj; //must cast the Object argument to the class type, in this case Shape

		double diff = area() - thisShape.area();
		if ( Math.abs(diff) <= epsilon*Math.abs(area()) )
			return 0;  //area of shape equals area of object
		else if (diff < 0)
			return -1;  //area of shape is less than area of object
		else
			return 1;  //area of shape is greater than area of object

	}
}

class Circle extends Shape {
	DecimalFormat df = new DecimalFormat("#.##");
	private final double PI = 3.14;
	private double radius;

	//constructor
	public Circle (double circleRadius, String circleName){
		super(circleName);
		radius = circleRadius;
	}

	public double perimeter(){
		return 2*PI*radius;
	}

	public double area(){
		double circleArea;
		circleArea = PI*radius*radius;
		circleArea = Double.valueOf(df.format(circleArea));
		return circleArea;
	}
}

class Square extends Shape {
	DecimalFormat df = new DecimalFormat("#.##");
	private double side;

	public Square(double squareSide, String squareName){
		super(squareName);
		side = squareSide;
	}

	public double perimeter(){
		return 4*side;
	}

	public double area(){
		double squareArea;
		squareArea = side*side;
		squareArea = Double.valueOf(df.format(squareArea));
		return squareArea;
	}

}

public class ShapeDemo {
	public static void main(String[] args){
		Shape s1 = new Circle(3.0, "circle");
		Shape s2 = new Square (4.5, "square");
		Shape s3 = new Square (4.5001, "square1");

		System.out.println("The area of " + s1.getName() + " is " + s1.area());
		System.out.println("The area of " + s2.getName() + " is " + s2.area());

		int compare = s2.compareTo(s1);
		System.out.println(compare);
		System.out.println(s3.compareTo(s2));

	}
	public static Comparable max(Comparable a, Comparable b)
	{
		if(a.compareTo(b) == 1) return a;
		else return b;
	}
}