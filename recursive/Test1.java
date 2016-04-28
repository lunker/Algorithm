public class Test1{


	static int n = 5;
	static int k = 2;
	public static void main(String[] asdsda){

		System.out.println("result;"+test(n,k));

	}

	public static int test(int n, int k){

		if(n==1)
			return 1;
		else
			return sqrt(n,k) + test(n-1,k);

	}
	public static int sqrt(int n, int k){


		if(k==1)
			return n;

		// 홀수
		if(k%2==1){
			return sqrt( n,(k-1)/2) * sqrt( n,(k-1)/2 ) * n ;
		}
		//짝수
		else{
			return sqrt( n, k/2) * sqrt( n, k/2);
		}
	}
}