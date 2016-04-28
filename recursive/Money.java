public class Money{


	public static int[] bills = {1,2,5,10,20,50};
		public static int billKind = 6;

		public static int money = 100;
		public static int count = 0;


	public static void main(String[] asdf){

		for(int i = 0 ; i < billKind ; i++){
			count += pick(money, i);
			System.out.println(count+"");
		}
		System.out.println(count+"");
	}

	public static int pick(int money, int bill){

		int count = 0 ;
		// base case
		// correct answer
		if(money - bills[bill] == 0)
			return 1;
		// can't be paid by this bill
		else if(money-bills[bill] < 0){
			return 0;
		}
		else{
			if( pick(money - bills[bill] , bill) == 0)
				pick(money, ++bill);
			else{
				count++;
				// pick(money,++bill);
			}

		}


		return count;
	}// end method

}