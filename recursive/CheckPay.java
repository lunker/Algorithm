public class CheckPay{


	static int[] bills = {1,2,5,10,20,50};
	static int size = 6;
	static int money = 100;
	static int total = 0;
	public static void main(String[] asdads){


		System.out.println("total count ; " + pick2(size, money, 0, 0));

	}

	public static int pick2(int size, int money, int currentBill, int moveBill){	


		if( currentBill == size - 1 && moveBill == size -1)
			return 0;

		if( money - bills[moveBill] > 0){

			// get right
			if(pick2(size, money - bills[moveBill], currentBill, moveBill) == 1){
				total++;
				return -1;			
			}
			// backtrack
			else{
				moveBill++;
				pick2(size, money, currentBill, moveBill);
			}
		}
		else if(money - bills[moveBill] == 0){
			return 1;
		}
		else{
			return -1;
		}
	}

	public static int pick(int size, int money, int currentBill, int moveBill){

		// end of all cases.
		// terminate function
		if( currentBill == size - 1 && moveBill == size -1)
			return 0;
		// correct bills 
		if(money - bills[moveBill] == 0 ){
			total++;
			return 1;
		}
		// still continue
		else if(money - bills[moveBill] > 0){
			if(pick(size, money, currentBill, moveBill) == 1)
				moveBill++;
		}
		//
		else{
			if(moveBill == size -1){
				moveBill = 0;
				return 0 ;
			}
			else{
				moveBill++;
				return pick(size, money, currentBill, moveBill);	
			}// end else
		}
		return 1;
/*
		if(currentBill == size && moveBill == size){
			return 2;
		}


		if( pick(size, money, currentBill, moveBill) ==1 ){
			pick(size, money - bills[moveBill], currentBill, moveBill);
		}
		// found the condition, 
		// 
		else if(pick() == 0){
			total++;
			return -1;
		}
		//back tracking , incre moveBill
		else{
			if(moveBill == size){
				moveBill = 0;
				currentBill++;
			}

			pick(size, money, currentBill, ++moveBill);

		}// end else
*/


	}// end mehtod
}