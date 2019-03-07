package classes1;

import java.util.Scanner;

class BankAccount{
	private double balance;							//account balance
	private static double intRate;
	private static double Overdraw_Penalty = 20.0;
	
	public BankAccount(double openingBalance)		//constructor
	{
		balance=openingBalance;
	}

	public void deposit(double amount)				//mutator: makes deposit
	{
		balance = balance+amount;
	}

	public void withdraw(double amount)				//mutator: makes withdrawal
	{
		if(amount > balance) balance -= amount + Overdraw_Penalty;
		else balance = balance-amount;
	}

	public double getBalance()						//accessor: displays balance
	{
		return(balance);
	}
	public static void setInterestRate()
	{
		System.out.println("Enter interest rate in decimal form");
		Scanner input = new Scanner(System.in);
		intRate = input.nextDouble();
		input.close();
	}
	public static void getInterestRate()
	{
		System.out.println("Today's interest rate is: " + intRate);
	}
}													// end class BankAccount

class BankApp{
	public static void main(String[] args){
		BankAccount c = new BankAccount(50.00);	//create a new BankAccount object

		//display balance of ba1
		System.out.println("Balance before transactions: "+ c.getBalance());


//		c.deposit(74.35);							//make a deposit of $74.35
		c.withdraw(50.05);							//make a withdrawal of $20.05
		
		//display balance of ba1
		System.out.println("Balance after transactions: " + c.getBalance());
		BankAccount.setInterestRate();
		BankAccount.getInterestRate();
	} 												//end main
}													//end class BankApp

