package Recursion;

import java.util.Scanner;

public class FactorialApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Find factorial of: ");
		int n = sc.nextInt();
		System.out.println("Factorial: " + factorial(n));
		sc.close();
	}
	
	public static int factorial(int n){
		if(n==1) return 1;
		return n*(factorial(n-1));
	}

}
