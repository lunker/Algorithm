import java.util.Scanner;

public class Main{


	private int totalCount = 0;


	public static void main(String[] asdf){
		Main m = new Main(); 
		m.start();

	}

	public void start(){

		Scanner scanner = new Scanner(System.in);
		int totalCount = scanner.nextInt();
		scanner.nextLine();

		int[] problemNums = new int[totalCount];
		int[][] problemLevels = new int[totalCount][];

		for(int i=0; i<totalCount; i++){
			/*
			 한 대회에서의 문제 수 
			*/

			problemNums[i] = scanner.nextInt();
			scanner.nextLine();

			problemLevels[i] = new int[problemNums[i]];
			// 레벨 입력 받기.
			String levels = scanner.nextLine();
			String[] levelsArray = levels.split(" ");

			for(int index=0; index<levelsArray.length; index++)
				problemLevels[i][index] = Integer.parseInt(levelsArray[index]);

		}
		/*
			input complete.
		*/

		for(int i=0; i<totalCount; i++){
			countProblem(problemNums[i], problemLevels[i]);
		}

	}// end start();

	public void countProblem(int size, int[] problems){

		// System.out.println("size : " + size + "problems : " + problems[0]);
		int count = 0;

		for(int i=0; i<size; i++){
			if(problems[i] == (i+1))
				count++;
		}

		System.out.println(count);
	}
}












