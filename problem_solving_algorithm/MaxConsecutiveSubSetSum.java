



public class MaxConsecutiveSubSetSum{


	static int[] data={3,5,8,-10,22,-1,24,21,-10,33,4,2,1};
	static int size = 13;

	static int[] sum = new int[size];

	public static void main(String[] asdf){


		findMax(0);
		
		for(int i=0;i<size;i++){
			if()
		}
	}

	public static void findMax(int index){

		if(index == size)
			return ;

		for(int move=index; move<size; move++){

			if( sum[index] < sum[index]+data[move]){
				sum += data[move]
			}
		}


		return findMax(index++);
	}
}