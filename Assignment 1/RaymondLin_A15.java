/*
 * 
 */
import java.util.*;

public class RaymondLin_A15 
{

	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		int D = kbd.nextInt();							//max difference between discs
		int N = kbd.nextInt();							//number of dics
		ArrayList<Integer> A = new ArrayList<Integer>(N);//peg A
		ArrayList<Integer> B = new ArrayList<Integer>(N);//peg B
		ArrayList<Integer> C = new ArrayList<Integer>(N);//peg C
		boolean complete = false;						//if tower is complete on peg C
		int cnt = 1;
		int topA;
		int topB;
		int topC;
		
		for(int i = 0; i<N; i++)
		{
			A.add(kbd.nextInt());
		}
		kbd.close();
		ArrayList<Integer> original = new ArrayList<Integer>(A); //original tower
		
		//even
		while(!complete) 
		{
			topA = 0;
			topB = 0;
			topC = 0;
			if(A.size()!=0)
			{
				topA = A.get(A.size()-1);
			}
			if(B.size()!=0)
			{
				topB = B.get(B.size()-1);
			}
			if(C.size()!=0)
			{
				topC = C.get(C.size()-1);
			}
			if(cnt%3 == 1) 
			{
				if(topA < topB)
				{
					B.add(topA);
					A.remove(A.size()-1);
				}
				else
				{
					A.add(topB);
					B.remove(B.size()-1);
				}
			}
			else if(cnt%3 == 2)
				if(topA < topC)
				{
					C.add(topA);
					A.remove(A.size()-1);
				}
				else
				{
					A.add(topC);
					C.remove(C.size()-1);
				}
			else 
			{
				if(topB < topC)
				{
					C.add(topB);
					B.remove(B.size()-1);
				}
				else
				{
					B.add(topC);
					C.remove(C.size()-1);
				}
			}
			if(C.equals(original)) 
			{
				complete = true;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
