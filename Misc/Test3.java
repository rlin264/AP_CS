
public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply(5,2));
	}
	public static int multiply(int a, int b)
	{
		if(b==0) return 0;
		return multiply(a,b-1) + a;
	}

}
