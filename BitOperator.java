public class BitOperator{



	static int n = 20;

	public static void main(String[] asdf){

		int a = 1;
		int result = 0;

		result |= (1<<1);
		// 집합의 원소 중 4 는 , 2^4로 표현한다. 즉 4번째 bit on.


		if( (result & (1<<1))!=0 ){
			System.out.println("1 is  in.");
		}
		System.out.println( (1 << n));

		for(int cases = 0; cases < (1<<(n)); cases++){
			System.out.print(cases+":");
			for(int i=0; i<n; i++){
				if( (cases & 1<<i ) !=0)
					System.out.print(i);
				// System.out.print( cases & 1<<i);
			}	
			System.out.println();
		}

		

	}
}