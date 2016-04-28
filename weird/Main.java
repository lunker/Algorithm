import java.util.ArrayList;
import java.util.Scanner;

public class Main{



	static int[] inputs ; 
	static ArrayList<Integer> divisors = new ArrayList();

	public static void main(String[] asa){

		getInput();

		for(int index = 0 ; index< inputs.length; index++){
			isWeird(inputs[index]);
		}
	}

	public static void getInput(){

		int testCases = -1;

		Scanner scanner = new Scanner(System.in);
		testCases = scanner.nextInt();

		scanner.nextLine();	

		inputs = new int[testCases];
		for(int i = 0 ;  i < testCases ; i++){
			inputs[i] = scanner.nextInt();
		}
	}

	public static void isWeird(int number){

		boolean firstCondition = false;
		boolean secondCondition = false;
		// 1 condition
		getDivisors(number, true);
		if( getSum() > number) {
			firstCondition = true;
		}
		else
			firstCondition = false;

		getDivisors( divisors.get( divisors.size() - 1 ), false);
		if(getSum() != number){
			secondCondition = true;
		}
		else
			secondCondition = false;


		// 2 condition
		if(firstCondition && secondCondition)
			System.out.println("weird");
		else
			System.out.println("not weird");

	}// end method
	public static void getDivisors(int number, boolean isFirst){
		divisors = new ArrayList();
		boolean flag = true;
		int divisor = 1;

		if(isFirst){
			while(flag){
				if(divisor < number){
					if( (number % divisor ) == 0 ){
						divisors.add(divisor);
					}
				}
				else
					break;
				divisor++;
			}// end while
			
		}
		else{
			while(flag){
				if(divisor <= number){
					if( (number % divisor ) == 0 )
						divisors.add(divisor);
				}// end if
				else
					break;
				divisor++;
			}// end while
		}
	}

	public static int getSum(){
		int sum = 0 ;

		for( int index = 0 ; index < divisors.size() ; index++ ){
			sum +=divisors.get(index);
		}
		return sum;
	}

}

