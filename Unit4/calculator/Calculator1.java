package calculator;

import java.util.*;

public class Calculator1 
{
	public static void main(String[] args) 
	{
		System.out.println(infixTopostfix("- 5 + 7 + 5 * 3"));
	}
	static int priority(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
	public static String infixTopostfix(String in)
	{
		String result = new String("");
		in = in.replaceAll("\\s+","");
		
		Stack<Character> stack = new Stack<>(); 
		for (int i = 0; i<in.length(); i++) 
        { 
            char c = in.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
            {
            	result += c + " "; 
            }  
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) 
                    result += stack.pop() + " "; 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()) 
            result += stack.pop() + " "; 
       
        return result; 
	}
	public static int evalPostfix(String in)
	{
		in = in.replaceAll("\\s+","");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i<in.length(); i++) 
		{
			char c = in.charAt(i); 
			if (Character.isLetterOrDigit(c)) //number
            {
            	numbers.add(Character.getNumericValue(c));
            }
			else
			{
				
			}
		}
		return 0;
	}
	
}
