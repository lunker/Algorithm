/**
	Q. 입력받은 문자열에는 괄호만 존재한다. 주어진 문자열의 괄호가 알맞게 작성 되었는지 검사하라. 
	input : {})((}))
	output : yes / no
*/

import java.util.Scanner;
public class Bracket{

	static String input = "({[]})";
	static char[] stack = new char[500];
	static int top = 0;


	public static void main(String[] asdf){

		System.out.println(bracket(input));
	}

	public static boolean bracket(String input){
		char[] inputCharArray = input.toCharArray();

		for(int i=0; i<input.length() ; i++){
			if(inputCharArray[i]=='(' || 
				inputCharArray[i] =='{' ||
				inputCharArray[i] == '['){
				
				stack[top++] = inputCharArray[i];
			}
			else{
				if(top-1 <0)
					return false;
				if( inputCharArray[i] != getPair(stack[--top]))
					return false;
			}
		}

		if(top == 0)
			return true;
		else
			return false;

	}// end method

	public static char getPair(char c){
		if(c == '(')
			return ')';
		else if(c == '{')
			return '}';
		else 
			return ']';

	}
}