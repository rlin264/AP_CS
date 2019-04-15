package unit5_6;

public class RectApp {
	public static void main(String[] args)
	{
		Rectangle r = new Rectangle(5,7);
		Rectangle r1 = new Rectangle(5,7);
		System.out.println(r.compareTo(r1));
	}
}
class Rectangle implements Comparable
{
	private double width, length;
	public Rectangle(){
		width = 1;
		length = 1;
	}
	public Rectangle(double length, double width)
	{
		this.length = length;
		this.width = width;
	}
	public double length()
	{
		return length;
	}
	public double width()
	{
		return width;
	}
	public double getArea()
	{
		return length*width;
	}
	public double getPerimeter()
	{
		return 2*(length + width);
	}
	public static void displayAreaFormula()
	{
		System.out.println("Area: length * width");
	}
	public int compareTo(Object obj) {
		final double epsilon = 1.0e-15;

		Rectangle thisShape = (Rectangle) obj; 
		
		if ( Math.abs(length() - thisShape.length()) <= epsilon*length() && Math.abs(width() - thisShape.width) <= epsilon*width())
			return 1;  
		else
			return -1;  
	}
}
