package Recursion;

import java.util.Scanner;

public class TriangleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = sc.nextInt();
		System.out.println("Triangle Number (using loops): " + triangleL(n));
		System.out.println("Triangle Number: " + triangle(n));
		sc.close();
	}
	public static int triangleL(int n)
	{
		int sum = 0;
		for(int i = 1; i <= n; i++)
		{
			sum += i;
		}
		return sum;
	}
	public static int triangle(int n)
	{
		if(n == 1) return 1;
		return n + triangle(n-1);
	}
}
