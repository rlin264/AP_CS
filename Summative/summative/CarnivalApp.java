package summative;

import java.util.ArrayList;
import java.util.Scanner;

public class CarnivalApp 
{
	public static void Main(String[] args)
	{
		Player player = new Player(20);
		GameBooth redBlack = new redBlack();
		player.play(redBlack);
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
			System.out.println("Press enter to draw a token"); sc.next();
			if(Math.random() > 0.5)
			{
				System.out.println("You drew a red token!");
				cnt++;
			}
			else System.out.println("You drew a black token!");
		}
		if(cnt == 0 || cnt == 3)
		{
			System.out.println("You won the Large Prize!");
			return 1;
		}
		else
		{
			System.out.println("You won the Large Prize!");
			return 2;
		}
	}
}
