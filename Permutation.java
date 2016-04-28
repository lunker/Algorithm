/**


	N개의 원소를 일렬로 줄 세우는 것.
	ex) 0,1,2,3,4,5 . . . . 
	ex) 1,0,2,3,4,5,6, . . . .

*/


public class Permutation{

	static int n = 3;
	static int[] data = {4,5,6};
	static int[] stack = new int[n];
	static int top = 0;

	static boolean[] visited = new boolean[n];


	public static void main(String[] asdfsadf){

		generate(n,0,0);
	}

	public static void generate(int n, int toPick){

		if(toPick==n){
			for(int i=0; i<n;i++){
				System.out.print(stack[i]);
			}
			System.out.println();
			return ;
		}

		for(int i=0; i<n; i++){

			if(!visited[i]){
				stack[toPick] = data[i];
				visited[i] =true;
				generate(n,toPick+1,i+1);	
				visited[i]= false;
			}
			

		}
	}


}