package classes1;

public class RaymondLin44 
{
	public static void main(String[] args)
	{
		Height h = new Height(70);
		System.out.println(h.getFeet() + "'" +h.getInches() + "\"");
		Height h1 = new Height(30);
		h.add(h1);
		System.out.println(h.getFeet() + "'" +h.getInches() + "\"");
	}
}
class Height
{
	private int feet, inches;
	public Height(int feet, int inches)
	{
		this.feet = feet;
		this.inches = inches;
		simplify();
	}
	public Height(int inches)
	{
		this.inches = inches;
		simplify();
	}
	public int getFeet()
	{
		return feet;
	}
	public int getInches()
	{
		return inches;
	}
	public void simplify()
	{
		inches = feet*12 + inches;
		feet = inches/12;
		inches = inches%12;
	}
	public void add(int inches)
	{
		this.inches += inches;
		simplify();
	}
	public void add(Height ht)
	{
		feet += ht.getFeet();
		inches += ht.getInches();
		simplify();
	}
}