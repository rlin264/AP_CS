package unit2_6;

import java.util.Arrays;

/* File: RaymondLin_266.java
 * Format text that satisfies the justify alignment
 * output string array satisfies	
 * a) The string is at most width symbols and contains as many words as possible. Remove extra spaces
 * b) The first word in the string begins at the first position. The last word ends at the second last
 * 	  position. The last position must contain a space with exception for the case if the last word
 * 	  was split into two parts.
 *    If extra spaces between the words in the String are needed, then they can be added as uniformly
 *    as possible
 * c) If a word or (a part of a word) has more symbols than width, then the word can be split into two
 *    parts. The length of the beginning part will be equal to width and will occupy the entire string
 *    The remaining part will be placed into the next string in the output array
 */
public class RaymondLin_266 
{
	public static void main(String[] args) 
	{
		String text = "Loremaaaaaaaaaaaaaaaaaaaaaaaaa ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor "
				+ "incididunt ut labore et dolore magna aliqua. Risus feugiat in ante metus dictum. "
				+ "Quis auctor elit sed vulputate mi sit.";
		String[] formatted = formatText(text, 25);	//formatted text in an array
		for(int i = 0; i < formatted.length; i++) 	//print out the formatted text
		{
			System.out.println(formatted[i]);
		}
	}
	public static String[] formatText(String text, int width)
	{
		String[] formatted = new String[text.length()/width];	//formatted string array that is at least the size of the length of the text divided by the width
		Arrays.fill(formatted, "");								//make all elements in formatted ""
		int pos1 = 0;											//index of the first letter of a word
		int pos2 = 0;											//index of the first letter of a word
		int row = 0;											//row number in formatted
		int words = 0;											//number of words in a row
		while(pos2 < text.length()) 							//while loop iterating through string
		{
			while(text.charAt(pos1) == ' ')	//ignore all spaces						
			{
				pos1++;
			}
			String word = "";				//string that contains the word
			pos2 = pos1;
			while(pos2 < text.length() && text.charAt(pos2) != ' ')	//waits until pos2 is a space so pos2 is the index of the last character of a word including punctuation
			{
				word += text.charAt(pos2);							//word adds the character at pos2
				pos2++;
			}
			if(word.length() > width)								//if the word is longer than the max allowed width
			{
				formatted[row] += word.substring(0, width);			//set the row equal to the max allowed characters of the word
				word = word.substring(width, word.length());		//word becomes the remaining part
				words = 1;
			}
			word += " ";											//add a space to the end of word
			pos1 = pos2;											//go to next word in the next loop so pos1 is at least pos2
			if((formatted[row]+word).length() > width) 				//if word to be added is going to overflow go to next line
			{
				formatted[row] = formatRow(formatted[row], width, words);//format the row properly so there are equally distributed spaces and a width as specified
				row++;
				words = 0;
			}
			try 									//tries to add word to row
			{
				formatted[row] += word;
			}
			catch(ArrayIndexOutOfBoundsException e) //if index out of bounds, then add a new row.
			{
			    // make array formatted one size larger
			    formatted = Arrays.copyOf(formatted, formatted.length + 1);
				formatted[row] += word;
			}
			words++;
		}
		formatted[row] = formatRow(formatted[row], width, words); //format the last row properly
		return formatted;
	}
	//the function formatRow adds spaces between words so that the length of the row becomes equal to width
	public static String formatRow(String row, int width, int num_words)
	{
		String[] words = row.split(" ");		//create an string array from the words in the row
		String formatted = "";					//final formatted row
		int length = 0;							//length of the formatted row
		int cnt = 0;							//count to keep track of which space between to rows is being added to
		for(int i = 0; i < words.length; i++)	//find the length of the original row
		{
			length += words[i].length();
		}
		while(length < width)					//loop until the length = width
		{
			words[cnt%(words.length-1)] += " ";	//cnt%words.length-1 because we do not want to add words to the last space which occurs after the last word in the row
			length++;
			cnt++;
		}
		for(int i = 0; i < words.length;i++) formatted += words[i];	//add the properly formatted words with the right number of spaces to the output string
		return formatted;
	}
}
