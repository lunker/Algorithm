
import java.util.Scanner;

class Decoder{



	public static void main(String[] asd){


	int testCases = -1;
	String[] inputs = null;
	char[] input = null;
	String result = "";


		Scanner sc = new Scanner(System.in);
		testCases = sc.nextInt();
		sc.nextLine();
		inputs = new String[testCases];

		for(int i = 0 ; i < testCases ; i++){
			inputs[i] = sc.nextLine();
		}

		for(int i = 0 ; i < testCases ; i++){
			input = inputs[i].toCharArray();
			for(int index = 0 ; index < input.length ; index++){


				try{
					if(input[index] == '%' && input[index+1] == '2'){

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
						}
					}// end outterif
					else
						result+=input[index];

				}catch(Exception e){
					result+=input[index];
					System.out.println(result);	
				}
				
			}// end inner loop
			System.out.println(result);
			result = "";
		}// end outer loop
	}//end main


}