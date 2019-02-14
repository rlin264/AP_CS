package unit4_1;

public class Fraction {
	
	//instance fields (use private for encapsulation)
	private int num = 0;
	private int den = 0;
	
	//constructor(s)
	//object has not yet been created so constructor creates.
	public Fraction(int num, int den)
	{
		this.num = num; //this.num refers to the num from the class (private int num = 0 on line 6)
		this.den = den;
	}
	
	public Fraction add(Fraction f)	//bound to the object. Cannot be bound to the class
	{
		this.num = this.num*f.den + f.num*this.den;
		this.den = this.den + f.den;
		
		return new Fraction(num, den);
	}
	public static Fraction add(Fraction a, Fraction b) //can bind to either object or class
	{
		int num = a.num*b.den + b.num*a.den;
		int den = a.den*b.den;
		
		return new Fraction(num, den);
	}
	public String toString()
	{
		return ("<" + this.num + "/" + this.den + ">");
	}
}
