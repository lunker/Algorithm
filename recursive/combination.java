public class combination{



	public static void main(String[] asd){


		System.out.println(pick(30,10));


	}


	public static int pick(int n, int r){

		if(r==1)
			return n;
		else
			return n * pick(n-1,r-1) / r;
	}
}