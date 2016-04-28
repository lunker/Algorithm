

import java.util.Scanner;
import java.util.*;

public class Main{

	static int testCases = -1;
	static String[] inputs = null;
	static HashMap<String, Integer> numberEncoding = new HashMap<>();
	static HashMap<Integer, String> numberDecoding = new HashMap<>();

	static char[][] charNums = new char[11][26];

	// static HashMap<Integer, Integer> charNum = new HashMap();
	// static HashMap<String, 
	public static void main(String[] asas){


		initialize();
		getInput();

		// char a = 'a';
		// System.out.println(a-'a');
		// System.out.println(   ((a-'a')== 0));
//
		for(int index = 0 ; index < testCases ; index++){
			String[] inputToken = inputs[index].split(" ");
			int operand1 = numberEncoding.get(inputToken[0]);
			int operand2 = numberEncoding.get(inputToken[2]);
			String strResult = inputToken[4];
			String operator = inputToken[1];
			int result = -1;
			
			
			if(operator.equals("+")){
				 result = operand1 + operand2;
			}
			else if(operator.equals("-")){
				 result = operand1 - operand2; 
			}
			else if(operator.equals("/")){
				 result = operand1 / operand2;
			}
			else{
				 result = operand1 * operand2;
			}
			if(result<0 || result >10)
				System.out.println("No");
			else{
				if(checkResult(result, strResult))
					System.out.println("Yes");
				else
					System.out.println("No");
			}	
		}

	}// end main
	
	public static void initialize(){

		numberEncoding.put("zero",0);
		numberEncoding.put("one", 1);
		numberEncoding.put("two",2);
		numberEncoding.put("three",3);
		numberEncoding.put("four",4);
		numberEncoding.put("five",5);
		numberEncoding.put("six",6);
		numberEncoding.put("seven",7);
		numberEncoding.put("eight",8);
		numberEncoding.put("nine",9);
		numberEncoding.put("ten",10);


		numberDecoding.put(0,"zero");
		numberDecoding.put(1,"one");
		numberDecoding.put(2,"two");
		numberDecoding.put(3,"three");
		numberDecoding.put(4,"four");
		numberDecoding.put(5,"five");
		numberDecoding.put(6,"six");
		numberDecoding.put(7,"seven");
		numberDecoding.put(8,"eight");
		numberDecoding.put(9,"nine");
		numberDecoding.put(10,"ten");
	}
	public static void getInput(){
		Scanner scanner = new Scanner(System.in);

		testCases = scanner.nextInt();
		scanner.nextLine();	

		inputs = new String[testCases];
		for(int i = 0 ;  i < testCases ; i++){
			inputs[i] = scanner.nextLine();
		}
	}
	public static boolean checkResult(int intResult, String strResult){
		
		String correct = numberDecoding.get(intResult);
		char[] strCorrectArray = correct.toCharArray();
		char[] strResultArray = strResult.toCharArray();
		
		
		for(int i = 0 ; i < correct.length() ; i ++){
		
			for( int index = 0 ; index < strResultArray.length ; index++){

				if(strResultArray[index] == strCorrectArray[i]){
					strResultArray[index] = 0;
					break;
				}
			}
		}  

		for(int index = 0 ; index < strResultArray.length ; index++){
			if(strResultArray[index] != 0)
				return false;

		}
		return true;
	}// end method
}