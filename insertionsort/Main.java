

public class Main{

	public static void main(String[] asd){

		int[] inputs = {5,4,3,2,1};
		insertionSort(inputs);

	}

	public static void insertionSort(int[] inputs){

		int size = inputs.length;

		for(int i = 0; i < size-1; i++){	

			int target = i+1;	

			while(  target >=1 &&inputs[target-1] > inputs[target] ){
				int tmp = inputs[target-1];
				inputs[target-1] = inputs[target];
				inputs[target] = tmp;
				target--;
			}
			for(int res = 0 ; res < size; res++)
				System.out.print(inputs[res]);		
			System.out.println();
		}

	}
}