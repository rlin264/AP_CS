package unit2_5;

public class RaymondLin_255 
{
	public static void main(String[] args)
	{
		
	}
	public static String encode(String s, String key, int shift)
	{
		String encrypt = "";
		for(int i = 0; i < s.length(); i++)
		{
			int pos = (key.indexOf(s.charAt(i))+shift)%key.length();
			encrypt += key.charAt(pos);
		}
		return s;
	}
}
