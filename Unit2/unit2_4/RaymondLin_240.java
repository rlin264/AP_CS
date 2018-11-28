package unit2_4;

public class RaymondLin_240 {

	public static void main(String[] args)
	{
		String a = "Morning";
		String[] names = new String[10];
 		String[] marks = new String[]{"A","A+","B-"};
 		String b = "Morning"; //refers to same place in memory as variable a
 		String c = new String ("Morning"); //refers to different place than b and a
 		a = a+b;
 		System.out.println(a);
 		System.out.println(b);
 		
 		if(a == b) System.out.println("Equal");
 		else System.out.println("Not equal");
 		
	}
}
