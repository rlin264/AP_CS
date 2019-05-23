package summative;

import java.util.ArrayList;
import java.util.Scanner;

public class CarnivalApp 
{
	public static void main(String[] args)
	{
		Player player = new Player(20);
		GameBooth redBlack = new redBlack();
		GameBooth pennyToss = new pennyToss();
		GameBooth skeetShooting = new skeetShooting();
		player.play(skeetShooting);
	}
}
class Player
{
	double spendingMoney;
	ArrayList<String> prizesWon = new ArrayList<String>();
	int result; //1 is large prize, 2 is small prize, 0 is no prize
	public Player(double spendingMoney)
	{
		this.spendingMoney = spendingMoney;
	}
	public void play(GameBooth game)
	{
		if(spendingMoney > game.getCost()){
			spendingMoney -= game.getCost();
			result = game.start();
			if(result == 1) prizesWon.add(game.largePrize);
			else if(result == 2) prizesWon.add(game.smallPrize);
		}
		else
		{
			System.out.println("You are out of money");
		}
	}
}
abstract class GameBooth
{
	double cost;
	String smallPrize;
	String largePrize;
	int sPrizesGiven;
	int lPrizesGiven;
	public GameBooth(double cost, String smallPrize, String largePrize)
	{
		this.cost = cost;
		this.smallPrize = smallPrize;
		this.largePrize = largePrize;
	}
	abstract int start();
	public double getCost()
	{
		return cost;
	}
}
class redBlack extends GameBooth
{
	Scanner sc = new Scanner(System.in);
	public redBlack()
	{
		super(1.50, "Plush Fish", "Keychain");
	}
	public int start()
	{
		int cnt = 0;	//red token count
		System.out.println("Welcome to Red or Black");
		System.out.println("Draw a token from the bag, then draw two more returning the token between each draw.");
		System.out.println("If all 3 tokens are the same colour (red or black), win a Plush Fish, else win a Keychain");
		for(int i = 0; i < 3; i++)
		{
			System.out.println("\nPress enter to draw a token"); sc.nextLine();
			if(Math.random() > 0.5)
			{
				System.out.println("You drew a red token!");
				cnt++;
			}
			else System.out.println("You drew a black token!");
		}
		if(cnt == 0 || cnt == 3)
		{
			System.out.println("You won the Large Prize: " + this.largePrize);
			this.lPrizesGiven++;
			return 1;
		}
		else
		{
			System.out.println("You won the Small Prize: " + this.smallPrize);
			this.sPrizesGiven++;
			return 2;
		}
	}
}
class pennyToss extends GameBooth
{
	Scanner sc = new Scanner(System.in);
	String[][] board;
	String[][] originalBoard = new String[][]{{"Poster", "Poster", "Plush Tiger", ""},
								{"", "Plush Tiger", "", "Poster"},
								{"Poster","","Poster",""},
								{"","","","Plush Tiger"}};
//	int[][] squaresHit = new int[4][4];
	public pennyToss()
	{
		super(3, "Poster", "Plush Tiger");
	}
	public int start()
	{
		board = new String[][]{{"Poster", "Poster", "Plush Tiger", ""},
				{"", "Plush Tiger", "", "Poster"},
				{"Poster","","Poster",""},
				{"","","","Plush Tiger"}};
		int largeCnt = 0;
		int smallCnt = 0;
		System.out.println("Welcome to Penny Toss");
		System.out.println("Toss 3 pennies onto the board");
		System.out.println("If all three pennies cover three Plush Tiger tiles, win the Plush Tiger");
		System.out.println("If any penny covers a Poster tile, win a Poster");
		printBoard();
		for(int i = 0; i < 3; i++)
		{
			System.out.println("\nPress enter to throw a penny"); sc.nextLine();
			int x = (int)(Math.random()*4);
			int y = (int)(Math.random()*4);
			board[x][y]+= " x";
			if(originalBoard[x][y].equals("Plush Tiger")) largeCnt++;
			else if(originalBoard[x][y].equals("Poster")) smallCnt++;
			printBoard();
		}
		if(largeCnt == 3)
		{
			System.out.println("You won the Large Prize: " + this.largePrize);
			this.lPrizesGiven++;
			return 1;
		}
		else if(smallCnt > 0)
		{
			System.out.println("You won the Small Prize: " + this.smallPrize);
			this.sPrizesGiven++;
			return 2;
		}
		else
		{
			System.out.println("You lose :(");
			return 0;
		}
	}
	public void printBoard()
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				System.out.printf("|%-15s|", board[i][j]);
			}
			System.out.println();
		}
	}
}
class skeetShooting extends GameBooth
{
	public skeetShooting()
	{
		super(2, "Toy Car", "Plush Dragon");
	}
	public int start()
	{
		shoot();
		return -1;
	}
	public void shoot()
	{
		try
		{
		    Thread.sleep((int)Math.random()*2000+500);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		printCircle();
	}
	public void printCircle() { 
		  
	    double dist; 
	    int radius = 4;
	    for (int i = 0; i <= 2 * radius; i++) { 
		    for (int j = 0; j <= 2 * radius; j++) { 
		        dist = Math.sqrt((i - radius) * (i - radius) + 
		                         (j - radius) * (j - radius)); 
		        if (dist > radius - 0.5 && dist < radius + 0.5) 
		        System.out.print("* "); 
		        else
		        System.out.print("  "); 
		    } 

	    System.out.print("\n"); 
	    } 
	} 
}
