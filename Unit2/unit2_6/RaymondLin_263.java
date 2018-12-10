package unit2_6;

public class RaymondLin_263 
{
	public static void main(String[] args) 
	{
		String text = "$ is excelling in the ICS4UN course.   @  has demonstrated great learning "
				+ "and is clearly passionate about # work. i am impressed.$ deserves a 5+";
		System.out.println(formatText(text, "Raymond", "M"));
	}
	public static String formatText(String text, String name, String gender)
	{
		/* remove extra spaces - including spaces between last word of a sentence and punctuation
		 * Add spaces where needed (after periods ,commas or other punctuation
		 * 	ab.cd -> ab. cd
		 * replace '$' with name
		 * replace '@' with he she they
		 * replace '#' with his her their
		 * Capitalize the first letter of the first word in each sentence
		 */
		//set pronous
		String pronoun,possessive;
		String formatted = "";
		int pos = 0;
		if(gender.toLowerCase().equals("m"))
		{
			pronoun = "he";
			possessive = "his";
		}
		else if(gender.toLowerCase().equals("f"))
		{
			pronoun = "she";
			possessive = "her";
		}
		else
		{
			pronoun = "they";
			possessive = "their";
		}
		
		while(pos < text.length())
		{
			char c = text.charAt(pos);
			if(c == '$')
			{
				formatted += name;
			}
			if(c == ' ')
			{
				formatted += c;
				while(text.charAt(pos) == ' ') pos++;
			}
			else
			{
				formatted += c;
			}
		}
		
		
		return formatted;
	}

}
