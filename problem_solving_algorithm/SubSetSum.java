/**

	
	Q-2.4 부분집합의 합


	input : 집합의 크기, 집합, 원하는 합계
	output : possible/ impossible

	-> 주어진 집합에서 부분집합들의 합으로 해당 합계가 가능한가? 



	Q-2.4.1 
	
	-> 가능하면, 합계를 구성하는 원소들을 출력해라 


*/


public class SubSetSum{


	static int n = 10;
	static int[] data = {6,9,13,14,20,21,22,30,49,55};
	// static int[] data = {10,20,30,40,50,60,70,80,90,100};
	static int goal = 110;
	static boolean[] visited = new boolean[n];

	public static void main(String[] asdf){


		// System.out.println(subset(0,0));
		System.out.println(subset2(0,0));

	}

	public static boolean subset(int currentIndex, int sum){

		// base case
		if(sum == goal){
			System.out.println("possible");
			return true;
		}
		if(currentIndex == n)
			return false;
		if(sum > goal)
			return false;

		for(int i=currentIndex; i<n; i++){
			if(sum+data[i] <= goal){
				// System.out.print(data[i]);
				subset(i+1, sum+data[i]);
			}
		}

		return false;
	}

	public static boolean subset2(int currentIndex, int sum){

		//base case
		
		if(sum>goal)
			return false;
		if(sum==goal){	
			System.out.println("possible");
			for(int i=0; i<n; i++){
				if(visited[i])
					System.out.print(data[i]);
			}
			System.out.println();
			System.out.println();
			return true;
		}
		if(currentIndex == n)
			return false;


		for(int i=currentIndex; i<n ;i++){
			if(!visited[i]){
				visited[i] = true;
				subset2(i+1, sum+data[i]);
				visited[i] = false;		
			}
		}
		// visited[currentIndex] = true;
		
		return false;
	}
}









