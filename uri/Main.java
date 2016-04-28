
import java.util.Scanner;

public class Main{


	static int testCases = -1;
	static String[] inputs = null;
	// static char[] input = null;
	static String result = "";



	public static void main(String[] asd){


		Scanner sc = new Scanner(System.in);
		testCases = sc.nextInt();
		sc.nextLine();
		inputs = new String[testCases];

		for(int i = 0 ; i < testCases ; i++){
			inputs[i] = sc.nextLine();
		}

		for(int i = 0 ; i < testCases ; i++){
			char[] input = inputs[i].toCharArray();
			int length = input.length;
			for(int index = 0 ; index < length ; index++){

					if(input[index] == '%' && (index+1 <= length-1 ) ){

						if(input[index+1] == '2' && ( (index+2) <= length-1)){
							if(input[index+2] == '0'){
								result+=" ";
								index+=2;
							}
							else if(input[index+2] == '1'){
								result+="!";
								index+=2;
							}
							else if(input[index+2] == '4'){
								result+="$";
								index+=2;
							}
							else if(input[index+2] == '5'){
								result+="%";
								index+=2;
							}
							else if(input[index+2] == '8'){
								result+="(";
								index+=2;
							}
							else if(input[index+2] == '9'){
								result+=")";
								index+=2;
							}
							else if(input[index+2] == 'a'){
								result+="*";
								index+=2;
							}
							else{
								result+=input[index];
								result+=input[index+1];
								index+=1;
							}
						}// end if==2
						else{
							// index+1 != 2 
							result+=input[index];
							// result+=input[index+1];
							// result+=2;
						}
						
					}// end outterif
					else
						result+=input[index];

				
			}// end inner loop
			System.out.println(result);
			result = "";
		}// end outer loop
	}//end main


}