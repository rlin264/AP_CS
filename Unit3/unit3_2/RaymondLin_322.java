package unit3_2;

public class RaymondLin_322
{
	public static void main(String[] args) 
	{
		System.out.println(reverseString("abcdefgh"));
	}
	public static String reverseString(String word)
	{
		if(word.length()<2)
			return word;
		return reverseString(word.substring(2))+word.charAt(1)+word.charAt(0);
	}
}
