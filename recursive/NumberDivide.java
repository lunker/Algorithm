public class NumberDivide{



	public static void main(String[] as){
		int n = 5;
		int m = 2;
		int result = 0;

		if(n > m )
			
			result = divide(n,m);
		else
			result = divide(n,n);
		System.out.println("result : " + result);
	}


	public static int divide(int n, int m){

		if(m==1)
			return 1;
		else if(m==2)
			return n/2 +1;
		else{
			return divide(n, m-1) + divide(n-m, m-1) + n/m -1;
		}
	}
}