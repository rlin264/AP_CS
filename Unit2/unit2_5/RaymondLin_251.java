package unit2_5;

public class RaymondLin_251 
{
	public static void main(String[] args)
	{
		System.out.println(numberOf("toronto", 'o'));
	}
	public static int numberOf(String str, char ch)
	{
		int cnt = 0;
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == ch) cnt++;
		}
		return cnt;
	}
}
