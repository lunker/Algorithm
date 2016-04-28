public class PI{

	static int[] data = {1,2,6,7,3,9,3,9};
	static int n = 8;

	public static void main(String[] asdf){

		System.out.println("result;"+level(0));

	}

	public static int level(int currentIndex){

		int min = 0;
		int lastIndex = 0;

		if(n - currentIndex < 3 )
			return 0;


		for(int i=0; i<2; i++){

			// 1 case
			if(data[currentIndex+i] == data[currentIndex+i+1] &&
				data[currentIndex+i+1] == data[currentIndex+i+2]){
				min =1;
				lastIndex = i;
			}
			// 2 case
			else if((data[currentIndex+i] - data[currentIndex+i+1]) - 
				(data[currentIndex+i+1] - data[currentIndex+i+2]) == 0 ){

				min = 2;
				lastIndex = i;
			}
			// 3 case
			else if(data[currentIndex+i] == data[currentIndex+i+2]){
				min = 4;
				lastIndex = i;
			}
			// 4 case
			else if(data[currentIndex+i] - data[currentIndex+i+1] == 
				data[currentIndex+i+1] - data[currentIndex+i+2]){
				min = 5;
				lastIndex = i;
			}
			else{
				min = 10;
				lastIndex = i;
			}
		}


		lastIndex = currentIndex + lastIndex + 3;

		return min + level(lastIndex);

	}
}