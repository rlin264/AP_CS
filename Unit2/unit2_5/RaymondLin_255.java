package unit2_5;

public class RaymondLin_255 
{
	public static void main(String[] args)
	{
		String s = "abcdef";
		String key = "abdf";
		int shift = 2;
		System.out.println(encode(s,key,shift));
	}
	public static String encode(String s, String key, int shift)
	{
		String encrypt = "";
		int ind = 0;
		for(int i = 0; i < s.length(); i++)
		{
			ind = key.indexOf(s.charAt(i));
			if(ind == -1) encrypt += s.charAt(i);
			else
			{
				int pos = (key.indexOf(s.charAt(i))+shift)%key.length();
				encrypt += key.charAt(pos);
			}
		}
		return encrypt;
	}
}
