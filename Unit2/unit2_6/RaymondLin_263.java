package unit2_6;

/* File: RaymondLin_263.java
 * remove extra spaces - including spaces between last word of a sentence and punctuation
 * Add spaces where needed (after periods ,commas or other punctuation)
 * 	 ab.cd -> ab. cd
 * replace '$' with name
 * replace '@' with he she they
 * replace '#' with his her their
 * Capitalize the first letter of the first word in each sentence
 */
public class RaymondLin_263 
{
	public static void main(String[] args) 
	{
		String text = "$ is excelling in the ICS4UN course.   @  has demonstrated great learning "
				+ "and is clearly passionate about # work. i am impressed.$ deserves a 5+.";
		
		System.out.println(formatText(text, "Raymond", "M"));
	}
	public static String formatText(String text, String name, String gender)
	{
		//set pronouns
		String pronoun,possessive, cap_pronoun, cap_possessive;
		String formatted = ""; 		//output string
		int pos = 0;				//position in the string text
		boolean capitalize = true;	//whether or not to capitalize char
		if(gender.toLowerCase().equals("m")) 		//male
		{
			pronoun = "he";
			cap_pronoun = "He";
			possessive = "his";
			cap_possessive = "His";
		}
		else if(gender.toLowerCase().equals("f"))	//female
		{
			pronoun = "she";
			cap_pronoun = "She";
			possessive = "her";
			cap_possessive = "Her";
		}
		else										//other
		{
			pronoun = "they";
			cap_pronoun = "They";
			possessive = "their";
			cap_possessive = "Their";
		}
		while(pos < text.length()) //while loop iterating through string
		{
			char c = text.charAt(pos); 	//character at index pos
			if(c == '$')				//replace '$' with name
			{
				formatted += name;
				capitalize = false;							//set capitalize to false since name is always capitalized
			}
			else if(c == '@')								//replace '@' with pronoun
			{
				if(capitalize) formatted += cap_pronoun;	//checks whether or not to capitalize
				else formatted += pronoun;
				capitalize = false;							//sets capitalize to false
			}
			else if(c == '#')								//replace '#' with possessive pronoun
			{
				if(capitalize) formatted += cap_possessive; //checks whether or not to capitalize
				else formatted += possessive;
				capitalize = false;							//sets capitalize to false
			}
			else if (c == '.' || c == ',' || c == '!' || c == '?' || c == ':' || c == ';'|| c == '-') 	//punctuation
			{
				formatted += c;																			//add punctuation to formatted
				if(pos < text.length() - 1 && text.charAt(pos+1) != ' ') formatted += ' ';
				if(c == '.' || c == '?' || c == '!') capitalize = true;									//if following a terminal punctuation, capitalize is true
			}
			else if(c == ' ')					//c is a space
			{
				formatted += c;					//add a space
				while(text.charAt(pos) == ' ') 	//skip spaces immediately following
				{
					pos++;
				}
				pos--;							//subtract 1 from pos since it is added at the end
			} 
			else if(capitalize)					//capitalize a character
			{
				formatted += Character.toUpperCase(c);
				capitalize = false;
			}
			else								//add character normally
			{
				formatted += c;
			}
			pos++;								//increase pos by one
		}
		
		
		return formatted;						//return formatted string
	}

}
