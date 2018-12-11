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
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor "
				+ "incididunt ut labore et dolore magna aliqua. Risus feugiat in ante metus dictum. "
				+ "Quis auctor elit sed vulputate mi sit.";
		String[] formatted = formatText(text, 25); 
		for(int i = 0; i < formatted.length; i++)
		{
			System.out.println(formatted[i]);
		}
	}
	public static String[] formatText(String text, int width)
	{
		String[] formatted = new String[text.length()/width + 5];
		//System.out.println(formatted.length);
		Arrays.fill(formatted, "");
		int pos1 = 0;
		int pos2 = 0;
		int row = 0;
		int words = 0;
		//System.out.println(text.length());
		while(pos2 < text.length()) 				//while loop iterating through string
		{
			while(text.charAt(pos1) == ' ')
			{
				pos1++;
			}
			String word = "";
			pos2 = pos1;
			while(pos2 < text.length() && text.charAt(pos2) != ' ')
			{
				word += text.charAt(pos2);
				pos2++;
			}
			if(word.length() > width)
			{
				formatted[row] += word.substring(0, width);
				word = word.substring(width, word.length());
				words = 1;
			}
			word += " ";
			pos1 = pos2;
			if((formatted[row]+word).length() > width) 
			{
				formatted[row] = formatRow(formatted[row], width, words);
				row++;
				words = 0;
			}
			formatted[row] += word;
			words++;
		}
		formatted[row] = formatRow(formatted[row], width, words);
		return formatted;
	}
	public static String formatRow(String row, int width, int num_words) //almost
	{
		String[] words = row.split(" ");
		String formatted = "";
		int length = 0;
		int cnt = 0;
		for(int i = 0; i < words.length; i++)
		{
			length += words[i].length();
		}
		while(length < width)
		{
			words[cnt%(words.length-1)] += " ";
			length++;
			cnt++;
		}
		for(int i = 0; i < words.length;i++) formatted += words[i];
		return formatted;
	}
}
