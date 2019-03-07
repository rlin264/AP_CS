package Recursion;

public class UpperLeftTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildTriangle(5);
	}
	public static void buildTriangle(int n)
	{
		if(n>0)
		{
			String s = new String(new char[n]).replace("\0", "*");
			System.out.println(s);
			buildTriangle(n-1);
		}
	}

}
