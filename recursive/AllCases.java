
public class AllCases{



	static int[] persons = {1,2,3,4,5,6};
	static int size = 6;


	public static void main(String[] asdsd){

		// pick(6,0,0,1);
		System.out.println("total : " + pick2(6,0,0)+"");
	}


	public static int pick(int size, int current, int move, int count){

		if(count == 0 ){
			System.out.println();
			if(move !=5){
				// move++;
				count++;
				return pick(size,current, move, count);
			}
			else{
				return 1;	
			}
		}
		else{
			System.out.print("("+persons[current] + "," + persons[move] +")");
			move++;
			count--;
			return pick(size, current, move, count);

		}
	}

	public static int pick2(int size, int current, int move){

		int count = 0 ;

		if(current != size){

			if(move != size){
				System.out.print("("+persons[current] + "," + persons[move] +")");
				count++;
				move++;
				return count + pick2(size, current, move);
			}
			else{

				current++;
				move = current;
				return count + pick2(size, current, move);
			}
		}
		else
			return 1;
	}

}