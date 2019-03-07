package classes1;

public class CoinApp {

	public static void main(String[] args) {
		Coin nickel = new Coin();
		if(nickel.flipCoin() == 0){
			System.out.println("Heads Up");
		}
		else{
			System.out.println("Tails Up");
		}
		
	}
}
class Coin {
	private int faceUp;
	public Coin(){
		faceUp = (int) (Math.random()*2);
	}
	public int flipCoin()
	{
		faceUp =  (int) (Math.random()*2);
		return faceUp;
	}
	public int showFace()
	{
		return faceUp;
	}
}
