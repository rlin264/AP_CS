package classes1;

public class RectApp {
	public static void main(String[] args)
	{
		Rectangle r = new Rectangle(5,7);
		System.out.println("Area: " + r.getArea());
		System.out.println("Perimeter: " + r.getPerimeter());
		Rectangle.displayAreaFormula();
	}
}
class Rectangle
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
}
