public class Combination{



	static int n = 4;
	static  int m = 2;
	static boolean[] selected = new boolean[n];


	public static void main(String[] asdf){

		generate(n,m,0);

	}

	public static void generate(int n, int m, int dataMove){

		if(m==0){
			for(int i=0; i<n; i++){
				if(selected[i])
					System.out.print(i);
			}
			System.out.println();

			return;
		}

		for(int index=dataMove ;index<n;index++){

			if(!selected[index]){

				selected[index]=true;
				generate(n,m-1, index+1);
				selected[index]=false;	
			}
		}





	}




}