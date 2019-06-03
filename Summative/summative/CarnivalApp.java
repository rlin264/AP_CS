package summative;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarnivalApp 
{
	public static void main(String[] args)
	{
		//declare a scanner for user input and decimal formatter
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#0.00");
		
		String inp = "";				//variable for user input
		
		Player player = new Player(15);	//create a player object with $15 starting money
		
		//create the three game booths for red or black, penny toss and skeet shooting
		GameBooth redBlack = new redBlack();
		GameBooth pennyToss = new pennyToss();
		GameBooth skeetShooting = new skeetShooting();
		
		System.out.println("Welcome to the Carnival!");
		System.out.println("Choose one of the options");
		System.out.println("You have $" + df.format(player.getMoney()));
		System.out.println("(G) Play a game\n(P) See Prizes\n(Q) Quit");
		System.out.println("Enter your choice");
		//game loop
		while(true)
		{
			inp = sc.nextLine();	//user input for a choice
			if(inp.toLowerCase().equals("g"))
			{
				System.out.println("Which game would you like to play?");
				System.out.println("(1) Red or Black ($1.50)\n(2) Penny Toss ($3.00)\n(3) Skeet Shooting ($2.00)");
				inp = sc.nextLine();	//user input for a choice
				//play the appropriate game depending on input
				if(inp.equals("1")) player.play(redBlack);
				else if(inp.equals("2")) player.play(pennyToss);
				else player.play(skeetShooting);
				
				//if the player does not have enough money to play any games, exit the game loop.
				if(player.getMoney() < 1.50)
				{
					System.out.println("You don't have enough money left to play any games");
					System.out.println("Prizes: " + Arrays.toString((player.prizesWon.toArray())));	//show the prizes the player won.
					//shows the number/types of prizes awarded by each game booth
					redBlack.prizesAwarded();
					pennyToss.prizesAwarded();
					skeetShooting.prizesAwarded();
					break;
				}
				
				System.out.println("Press enter to continue"); //the user  see what their result is before continuing.
			}
			else if(inp.toLowerCase().equals("p"))
			{
				System.out.println("Which game would you like to see the prizes for?");
				System.out.println("(1) Red or Black\n(2) Penny Toss\n(3) Skeet Shooting");
				inp = sc.next();	//user input for a choice
				//show the appropriate prizes depending on input
				if(inp.equals("1")) redBlack.printPrizes();
				else if(inp.equals("2")) pennyToss.printPrizes();
				else skeetShooting.printPrizes();
			}
			else if(inp.toLowerCase().equals("q"))
			{
				System.out.println(Arrays.toString((player.prizesWon.toArray())));	//show the prizes the player won.
				//shows the number/types of prizes awarded by each game booth
				redBlack.prizesAwarded();
				pennyToss.prizesAwarded();
				skeetShooting.prizesAwarded();
				break;
			}
			else
			{
				//print out the options the player has
				System.out.println("Choose one of the options");
				System.out.println("You have $" + df.format(player.getMoney()));
				System.out.println("(G) Play a game\n(P) See Prizes\n(Q) Quit");
				System.out.println("Enter your choice");
			}
		}
	}
}
class Player
{
	double spendingMoney;	//spending money that the player has
	ArrayList<String> prizesWon = new ArrayList<String>();	//String arrayLIst containing all prizes the player has won
	int result; //result after each game played. 1 is large prize, 2 is small prize, 0 is no prize
	
	//constructor
	public Player(double spendingMoney)
	{
		this.spendingMoney = spendingMoney;
	}
	//method to play a game
	public void play(GameBooth game)
	{
		if(spendingMoney > game.getCost()){	//check if the player has enough money to play the game
			spendingMoney -= game.getCost();//subtract appropriate amount of money
			result = game.start();			//start the game
			//add the appropriate prize is the player won one
			if(result == 1) prizesWon.add(game.largePrize);
			else if(result == 2) prizesWon.add(game.smallPrize);
		}
		else
		{
			System.out.println("You don't have enough money to play " + game.name);
		}
	}
	//accessor for spendingMoney
	public double getMoney()
	{
		return spendingMoney;
	}
}
//game booth class
abstract class GameBooth
{
	double cost;		//cost of the game
	String smallPrize;	//name of the small prize
	String largePrize;	//name of the large prize
	String name;		//name of the game
	int sPrizesGiven;	//number of small prizes given
	int lPrizesGiven;	//number of large prizes given
	//constructor method
	public GameBooth(double cost, String smallPrize, String largePrize, String name)
	{
		this.cost = cost;
		this.smallPrize = smallPrize;
		this.largePrize = largePrize;
		this.name = name;
	}
	//abstract start method that will return a result (int). depends on the game
	abstract int start();
	//accessor for cost of the game
	public double getCost()
	{
		return cost;
	}
	//print a string for the prizes offerred
	public void printPrizes()
	{
		System.out.println("The large prize is a " + this.largePrize + " and the small prize is a " + this.smallPrize);
	}
	//print a string for the number of each prize awarded/
	public void prizesAwarded()
	{
		System.out.println(name + " gave out " + sPrizesGiven + " small prizes and " + lPrizesGiven + " large prizes.");
	}
}
class redBlack extends GameBooth
{
	Scanner sc = new Scanner(System.in);
	public redBlack()
	{
		super(1.50, "Keychain", "Plush Fish", "Red or Black");
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
	public pennyToss()
	{
		super(3, "Poster", "Plush Tiger", "Penny Toss");
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
		super(2, "Toy Car", "Plush Dragon", "Skeet Shooting");
	}
	public int start()
	{
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println("Welcome to Skeet Shooting");
		System.out.println("A skeet will be shot and displayed on the screen. The skeet will have a sequence of the letters WASD.");
		System.out.println("Type the letters in order with an enter in between each one to aim and shoot at the skeet");
		System.out.println("Aim properly at the skeet in under 3 seconds to earn the Plush Dragon, under 4 to earn the Toy Car.");
		System.out.println("If over 4 seconds or you aim badly (wrong inputs) you will miss the skeet and get nothing.");
		System.out.println("\nPress enter to start Skeet Shooting"); sc.nextLine();
		try
		{
		    Thread.sleep((int)Math.random()*3000+500);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		String s = makeSkeet();
		long startTime = System.currentTimeMillis();
		boolean complete = aim(s);
		long endTime = System.currentTimeMillis();
		double seconds = (endTime - startTime) / 1000.0;
		if(complete)
		{
			System.out.println("You shot in " + df.format(seconds) + "!");
			if(seconds < 3)
			{
				System.out.println("That's under 3 seconds! You hit the skeet dead on!");
				System.out.println("You won the Large Prize: " + this.largePrize);
				this.lPrizesGiven++;
				return 1;
			}
			else if(seconds < 4)
			{
				System.out.println("That's under 4 seconds! You hit the skeet!");
				System.out.println("You won the Small Prize: " + this.smallPrize);
				this.sPrizesGiven++;
				return 2;
			}
			else
			{
				System.out.println("That's over 4 seconds! Too slow!");
				System.out.println("You missed");
				return 0;
			}
		}
		else
		{
			System.out.println("You missed!");
			return 0;
		}
	}
	public String makeSkeet() {
		String[] letters = new String[]{"w", "a", "s", "d"};
		String s = "";
		int s_ind = 0;
		for(int i = 0; i < 5; i++)
		{
			s += letters[(int)(Math.random()*4)];
		}
	    double dist; 
	    int radius = 4;
	    for (int i = 0; i <= 2 * radius; i++) { 
		    for (int j = 0; j <= 2 * radius; j++) { 
		        dist = Math.sqrt((i - radius) * (i - radius) + 
		                         (j - radius) * (j - radius)); 
		        if (dist > radius - 0.5 && dist < radius + 0.5) System.out.print("* "); 
		        else if(i == 4 && (j > 1 && j < 7))
		        {
		        	System.out.print(s.charAt(s_ind) + " ");
		        	s_ind++;
		        }
		        else
		        {
		        	System.out.print("  ");
		        }
		    } 
	    System.out.print("\n"); 
	    }
	    return s;
	}
	public boolean aim(String s)
	{
		Scanner sc = new Scanner(System.in);
		char[] inputs = s.toCharArray();
//		System.out.println(Arrays.toString(inputs));
		boolean complete = true;
		for(int i = 0;i < 5; i++)
		{
			if(!sc.nextLine().equals(Character.toString(inputs[i])))
			{
				complete = false;
			}
		}
		return complete;
	}
}
