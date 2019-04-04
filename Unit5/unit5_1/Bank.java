package unit5_1;

import java.util.Scanner;
import java.text.NumberFormat;

public class Bank {
	public static void main(String[] args) {
		Account decmAccount = new Account(250, "Matthew", "DeClerico", "123 Front Street", "Toronto", "ON");
		Scanner input = new Scanner(System.in);
		double data;
		NumberFormat money = NumberFormat.getCurrencyInstance();

		System.out.println(decmAccount.toString());

		System.out.print("Enter deposit amount: ");
		data = input.nextDouble();
		decmAccount.deposit(data);
		System.out.println("Balance is: " + money.format(decmAccount.getBalance()));

		System.out.print("Enter withdrawal amount: ");
		data = input.nextDouble();
		decmAccount.withdrawal(data);
		System.out.println("Balance is: " + money.format(decmAccount.getBalance()));
		
		decmAccount.changeAddress("371 Bloor St W", "Toronto", "Ontario");
		System.out.println(decmAccount.toString());
		input.close();
	}
}

class Account {
	private double balance;
	private Customer cust;


	public Account(double bal, String fName, String lName, String street, String city, String prov) {
		balance = bal;
		cust = new Customer(fName, lName, street, city, prov);
	}


	public double getBalance() {
		return(balance);
	}

	public void deposit(double amt) {
		balance += amt;
	}

	public void withdrawal(double amt) {
		if (amt <= balance) {
			balance -= amt;
		} else {
			System.out.println("Not enough money in account.");
		}
	}

	public String toString() {
		String accountString;
		NumberFormat money = NumberFormat.getCurrencyInstance();
  		accountString = cust.toString();
  		accountString += "Current balance is " + money.format(balance);
  		return(accountString);
  	}
	
	public void changeAddress(String s, String c, String p)
	{
		cust.changeStreet(s);
		cust.changeCity(c);
		cust.changeProv(p);
	}

}

class Customer {
	private String firstName, lastName, street, city, province;

	public Customer(String fName, String lName, String s, String c, String p) {
		firstName = fName;
		lastName = lName;
		street = s;
		city = c;
		province = p;
	}

 	// Returns a String that represents the Customer object
 	public String toString() {
		String custString;
	  	custString = firstName + " " + lastName + "\n";
	  	custString += street + "\n";
	  	custString += city + ", " + province + "\n";
	  	return(custString);
	  	}
 	public void changeStreet(String s)
 	{
 		street = s;
 	}
 	public void changeCity(String c)
 	{
 		city = c;
 	}
 	public void changeProv(String p)
 	{
 		province = p;
 	}
}