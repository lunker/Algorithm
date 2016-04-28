public class ExhaustiveSearch{




	static int[] data = {1,2,3,4,5};
	static boolean[] dataVisited = new boolean[5];

	public static void main(String[] asda){


		int n = 5;
		int r = 3;

		search(n,r);

	}
	public static void search(int n, int r){

		if(r==0){
			for(int i=0; i<n;i++){
				if(dataVisited[i]==true)
					System.out.print(data[i]);		
			}
			System.out.println();
			return;
		}
		else{
			for(int i=0; i<n; i++){
				if(dataVisited[i]==false){
					// System.out.print(data[i]);
					dataVisited[i]=true;
					search(n,r-1);
					dataVisited[i]=false;
				}
			}
		}
	}
}


	