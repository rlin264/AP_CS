package unit5_5;

import java.util.Scanner;

public class MusicPerformance {

	public static void main(String[] args) {
		String name;
		String instrumentChoice;
		Scanner input = new Scanner(System.in);
		System.out.println("Select an instrument for the band member. ");
		System.out.print("(V)ocals, (P)iccolo, or (C)larinet: ");
		instrumentChoice = input.nextLine();
		System.out.print("Enter the band member's name: ");
		name = input.nextLine();
		Object bandMember;
			if (instrumentChoice.equalsIgnoreCase("V")) {
				bandMember = new Vocal(name);
			} else if (instrumentChoice.equalsIgnoreCase("P")) {
				bandMember = new Piccolo(name);
			} else { 					//default to clarinet
				bandMember = new Clarinet(name);
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

class Piccolo extends Instrument {

	//constructor: A piccolo has been created
	public Piccolo(String picc) {
		super(picc);
	}

 	//implimenting the abstract method: returns sound made by the piccolo
 	public String makeSound() {
	 	return("peep");
	}

	//A string represting the piccolo

		public String toString() {
			String piccoloPlayer;
			piccoloPlayer = super.getMusician();
			piccoloPlayer += " plays " + makeSound() + ".";
			return(piccoloPlayer);
	}
}

class Clarinet extends Instrument {

	//constructor: A Clarinet has been created
	public Clarinet(String clar) {
		super(clar);
	}

 	//implimenting the abstract method: returns sound made by the clarinet
 	public String makeSound() {
	 	return("sqawk");
	}

	//A string represting the clarinet

		public String toString() {
			String clarinetPlayer;
			clarinetPlayer = super.getMusician();
			clarinetPlayer += " plays " + makeSound() + ".";
			return(clarinetPlayer);
	}
}



