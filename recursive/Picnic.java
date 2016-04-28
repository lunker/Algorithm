import java.util.Scanner;

public class Picnic{


	// 0,1,2,3
	static int testCases = -1;
	static Scanner scanner = new  Scanner(System.in);



	static int[] friendNum = null;
	static int[][] friendPairSet = null;

	static boolean[] visited = null;
	static int[] pairList = null;
	public static void main(String[] asdsad){

		System.out.println(scanner.nextInt()+""+scanner.nextInt());
		testCases = scanner.nextInt();
		friendPairSet = new int[];

		for(int i=0; i<testCases; i++){
			// 친구의 수 
			friendNum[i] = scanner.nextInt();
			// 친구 관계의 수 
			friendPairSet[i] = new int[scanner.nextInt()*2];

			// add friends pair
			for(int s=0; s< friendPairSet[i].length; s++){
				friendPairSet[i][s] = scanner.nextInt();
			}
		} 

		// do search 
		for(int i=0; i<testCases; i++){
			pairList = new int[friendNum];
			visited = new boolean[friendNum[i]];


			System.out.println(casesByRecur(i,0));
		}
		casesByLoop();
	}

	public static void casesByLoop(){
		;
	}

	public static int casesByRecur(int i, int currentLocation){

		int count =0;
		if(currentLocation == friendNum[i]){
			// check correct friend pair

			for(int tmpIdx=0; tmpIdx<)
			return;
		}


		for(int i=0; i<friendNum[])
	}
}






