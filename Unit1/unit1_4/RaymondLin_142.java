package unit1_4;
/*File: RaymondLin_142.java
This programs sorts 3 words into lexicographical order.
*/
import java.util.*;

public class RaymondLin_142
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String word1 = sc.next(); //first word
		String word2 = sc.next(); //second word
		String word3 = sc.next(); //third word
		String temp;



		if(word1.compareTo(word2) > 0) //if word1 comes after word2 lexicographically, swap them
		{
			temp = word1;
			word1 = word2;
			word2 = temp;
		}
		if(word2.compareTo(word3) > 0) //if word2 comes after word3 lexicographically, swap them
		{
			temp = word2;
			word2 = word3;
			word3 = temp;
		}
		if(word1.compareTo(word2) > 0) //if word1 comes after word2 lexicographically, swap them
		{
			temp = word1;
			word1 = word2;
			word2 = temp;
		}
		if(word1.compareTo(word3) > 0) //if word1 comes after word3 lexicographically, swap them
		{
			temp = word3;
			word3 = word1;
			word1 = temp;
		}

		System.out.println(word1);
		System.out.println(word2);
		System.out.println(word3);
		sc.close();

	}
}