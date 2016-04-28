
/**
		

	1,2,3,4,5...n의 순열.
	ex) 1,3,5,4,2 -> (3,2) , (5,4), (5,2), (4,2) 

	이와 같은 것을 역전되었다고 한다.

	주어진 순열에 대해서 역전된 쌍의 갯수를 계산해라.

*/


public class Test2{

	static int[] data = {1,3,5,4,2};
	static int size = 5;

	public static void main(String[] asd){


		System.out.println("result;"+ test(0));

	}

	public static int test(int current){

		int count = 0;
		if(current == (size-1)){
			return 0;
		}
		else{
			for(int i = current; i < size ; i++){
				if(data[current] > data[i]){
					count++;
				}	
			}
			current++;
			return count + test(current);
		}
	}
}