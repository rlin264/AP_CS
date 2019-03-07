package assignment4;

public class RaymondLin_a4_1 {

}
class DreamVacation
{
	private String destination;
	private double cost;
	
	public DreamVacation()
	{
		destination = "Toronto";
		cost = 500.00;
	}
	public DreamVacation(String destination, double cost)
	{
		this.destination = destination;
		this.cost = cost;
	}
	public String getDestination()
	{
		return destination;
	}
	public double getCost()
	{
		return cost;
	}
	public void changeDestination(String destination)
	{
		this.destination = destination;
	}
	public void changeCost(double cost)
	{
		this.cost = cost;
	}
}
