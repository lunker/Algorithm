public class InvestMax{




	static int money = 4;
	static int company = 3;

	static int[][] benefits = {
		{2,3,1}, // 만원투자시 
		{4,5,3}, // 2만원
		{6,6,7}, // 3만원 
		{9,8,9} //  4만원 
	};

	static int[] maxBenefits = new int[money];


	public static void main(String[] asd){
		System.out.println("result;"+dynamicMax(4));
	}
	public static int max(int money){
		return 1;

	}
	public static int dynamicMax(int money){

		for(int i=0; i<money; i++){
			if(i==0){
				maxBenefits[i] = benefits[i][findMaxIndex(i,-1)];
			}
			else{
				int tmp = 0;
				tmp = findMaxIndex(i-1,-1);

				maxBenefits[i] = benefits[i-1][tmp] + benefits[0][findMaxIndex(1, tmp)];
			}
		}

		return maxBenefits[money-1];
	}
	public static int findMaxIndex(int row, int except){
		int tmp = 0;
		for(int i = 0 ; i < company ; i++){


			if(benefits[row][i] > tmp){
				if(i != except)
					tmp = i;
			}
		}
		return tmp;
	}
}