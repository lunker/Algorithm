import java.util.Scanner;

/**

	not solved
*/


public class WildCard{


	static Scanner scanner = new Scanner(System.in);
	static int testCases = -1;
	static String[] patterns = null;

	public static void main(String[] asdf){


		/*

		testCases = scanner.nextInt();
		scanner.nextLine();


		patterns = new String[testCases];

		for(int i=0; i<testCases; i++){

			int inputStrNum = -1;
			patterns[testCases] = scanner.nextLine();
			inputStrNum = scanner.nextInt();
			String[] inputStr = new String[inputStrNum];
			for(int j=0; j< inputs; j++){
				inputStr[j] = scanner.nextLine();
			}
		}
		*/

		String pattern = "he?p";
		String input = "hellp";
		System.out.println(isMatched(pattern.toCharArray(), pattern.toCharArray()));
	}

	public static boolean isMatched(char[] pattern, char[] input){

		int index=0;

		while(pattern[index++] != '?')
			;

		for(int i=0;i<;i++){
			if(pattern[i] != input[i])
				return false;
		}


		return true;
	}// end method
}












