package summative;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarnivalApp 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String inp = "";
		
		
		Player player = new Player(20);
		boolean[] canPlay = new boolean[] {true,true,true};
		GameBooth redBlack = new redBlack();
		GameBooth pennyToss = new pennyToss();
		GameBooth skeetShooting = new skeetShooting();
//		player.play(skeetShooting);
		System.out.println("Welcome to the Carnival!");
		System.out.println("Choose one of the options");
		while(true)
		{
			System.out.println("Choose one of the options");
			System.out.println("(G) Play a game\n(P) See Prizes\n(Q) Quit");
			System.out.println("Enter your choice");
			if(sc.hasNextLine())
			inp = sc.nextLine();
			if(inp.toLowerCase().equals("g"))
			{
				//Game code
				System.out.println("Which game would you like to play?");
				System.out.println("(1) Red or Black\n(2) Penny Toss\n(3) Skeet Shooting");
				inp = sc.nextLine();
				if(inp.equals("1")) canPlay[0] = player.play(redBlack);
				else if(inp.equals("2")) canPlay[1] = player.play(pennyToss);
				else canPlay[2] = player.play(skeetShooting);
				
				if(canPlay[0] == false && canPlay[1] == false && canPlay[2] == false)
				{
					System.out.println(Arrays.toString((player.prizesWon.toArray())));
					redBlack.prizesAwarded();
					pennyToss.prizesAwarded();
					skeetShooting.prizesAwarded();
					break;
				}
			}
			else if(inp.toLowerCase().equals("p"))
			{
				System.out.println("Which game would you like to see the prizes for?");
				System.out.println("(1) Red or Black\n(2) Penny Toss\n(3) Skeet Shooting");
				inp = sc.next();
				if(inp.equals("1")) redBlack.printPrizes();
				else if(inp.equals("2")) pennyToss.printPrizes();
				else skeetShooting.printPrizes();
			}
			else
			{
				System.out.println(Arrays.toString((player.prizesWon.toArray())));
				redBlack.prizesAwarded();
				pennyToss.prizesAwarded();
				skeetShooting.prizesAwarded();
				break;
			}
		}
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
	public boolean play(GameBooth game)
	{
		if(spendingMoney > game.getCost()){
			spendingMoney -= game.getCost();
			result = game.start();
			if(result == 1) prizesWon.add(game.largePrize);
			else if(result == 2) prizesWon.add(game.smallPrize);
			return true;
		}
		else
		{
			System.out.println("You are out of money");
			return false;
		}
	}
	public double getMoney()
	{
		return spendingMoney;
	}
}
abstract class GameBooth
{
	double cost;
	String smallPrize;
	String largePrize;
	String name;
	int sPrizesGiven;
	int lPrizesGiven;
	public GameBooth(double cost, String smallPrize, String largePrize, String name)
	{
		this.cost = cost;
		this.smallPrize = smallPrize;
		this.largePrize = largePrize;
		this.name = name;
	}
	abstract int start();
	public double getCost()
	{
		return cost;
	}
	public void printPrizes()
	{
		System.out.println("The large prize is " + this.largePrize + " and the small prize is " + this.smallPrize);
	}
	public void prizesAwarded()
	{
		System.out.println(name + " gave out " + sPrizesGiven + " small prizes and " + lPrizesGiven + "large prizes.");
	}
}
class redBlack extends GameBooth
{
	Scanner sc = new Scanner(System.in);
	public redBlack()
	{
		super(1.50, "Plush Fish", "Keychain", "Red or Black");
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
		DecimalFormat df = new DecimalFormat("#0.00");
		try
		{
		    Thread.sleep((int)Math.random()*2000+500);
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
			if(!sc.next().equals(Character.toString(inputs[i])))
			{
				complete = false;
			}
		}
		sc.close();
		return complete;
	}
}
