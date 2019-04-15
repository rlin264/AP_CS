package unit5_5;

import java.util.Scanner;

public class MusicPerformance {

	public static void main(String[] args) {
		String name;
		String instrumentChoice;
		Scanner input = new Scanner(System.in);
		System.out.println("Select an instrument for the band member. ");
		System.out.print("(V)ocals, (P)iccolo,(C)larinet, (D)rums, (Cy)mbal: ");
		instrumentChoice = input.nextLine();
		System.out.print("Enter the band member's name: ");
		name = input.nextLine();
		Instrument bandMember;
			if (instrumentChoice.equalsIgnoreCase("V")) {
				bandMember = new Vocal(name);
			} else if (instrumentChoice.equalsIgnoreCase("P")) {
				bandMember = new Piccolo(name);
			} else if(instrumentChoice.equalsIgnoreCase("C")){ 
				bandMember = new Clarinet(name);
			} else if(instrumentChoice.equalsIgnoreCase("D")){ 
				bandMember = new Drum(name);
			} else {
				bandMember = new Cymbal(name);
			}
		System.out.println(bandMember);
	}
}

abstract class Instrument{
	private String musician;
	public Instrument(String name)
	{
		musician = name;
	}

	public String getMusician()
	{
		return musician;
	}
	public abstract String makeSound();
	public abstract String toString();
}

class Vocal extends Instrument {

	//constuctor: a vocalist has been created
	public Vocal (String singerName){
		super(singerName);
	}

	//implimenting the abstract method: returns sound of vocalist
	public String makeSound() {
		return ("LaLaLa");
	}

	//A string represting the vocalist

	public String toString() {
		String singer;
		singer = super.getMusician();
		singer += " sings " + makeSound() + ".";
		return(singer);
	}
}

abstract class Woodwind extends Instrument{
	public Woodwind(String name)
	{
		super(name);
	}

	public String makeSound() {
		return("toot");
	}
}
abstract class Percussion extends Instrument{
	public Percussion(String name)
	{
		super(name);
	}
}

class Piccolo extends Woodwind {

	//constructor: A piccolo has been created
	public Piccolo(String picc) {
		super(picc);
	}

 	//implimenting the abstract method: returns sound made by the piccolo
// 	public String makeSound() {
//	 	return("peep");
//	}

	//A string represting the piccolo

		public String toString() {
			String piccoloPlayer;
			piccoloPlayer = super.getMusician();
			piccoloPlayer += " plays " + makeSound() + ".";
			return(piccoloPlayer);
	}
}

class Clarinet extends Woodwind{

	//constructor: A Clarinet has been created
	public Clarinet(String clar) {
		super(clar);
	}

// 	//implimenting the abstract method: returns sound made by the clarinet
// 	public String makeSound() {
//	 	return("sqawk");
//	}

	//A string represting the clarinet

		public String toString() {
			String clarinetPlayer;
			clarinetPlayer = super.getMusician();
			clarinetPlayer += " plays " + makeSound() + ".";
			return(clarinetPlayer);
	}
}
class Drum extends Percussion{

	public Drum(String name) {
		super(name);
	}

 	public String makeSound() {
	 	return("boom");
	}

	public String toString() {
		String drum;
		drum = super.getMusician();
		drum += " plays " + makeSound() + ".";
		return(drum);
	}
}
class Cymbal extends Percussion{

	public Cymbal(String name) {
		super(name);
	}

 	public String makeSound() {
	 	return("crash");
	}

	public String toString() {
		String cymbal;
		cymbal = super.getMusician();
		cymbal += " plays " + makeSound() + ".";
		return(cymbal);
	}
}





