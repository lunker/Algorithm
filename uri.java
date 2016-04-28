

class Decoder{



	int testCases = -1;
	String[] inputs = null;
	String input = "";
	String result = "";
	public static void main(String[] asd){


		Scanner sc = new Scanner(System.in);
		testCases = sc.nextInt();

		inputs = new String[testCases];

		for(int i = 0 ; i < testCases ; i++){
			inputs[i] = sc.nextLine();
		}

		for(int i = 0 ; i < testCases ; i++){
			input = inputs[i];
			for(int index = 0 ; i < input.length ; i++){


				// if it is encoded char
				if(input[index].equals("%") && input[index+1].equals("2")){
					if(input[index+2].equals("0")){
						result+=" ";
					}
					else if(input[index+2].equals("1")){
						result+="!";
					}
					else if(input[index+2].equals("4")){
						result+="$";
					}
					else if(input[index+2].equals("5")){
						result+="%";
					}
					else if(input[index+2].equals("8")){
						result+="(";
					}
					else if(input[index+2].equals("9")){
						result+=")";
					}
					else if(input[index+2].equals("a")){
						result+="*";
					}

				}
				else
					result+=input[index];
			}// end inner loop
			System.out.println(result);
			result = "";
		}// end outer loop
	}//end main


}