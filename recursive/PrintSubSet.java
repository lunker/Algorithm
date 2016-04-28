public class PrintSubSet{


	static int n = 20;
	static int[] set= new int[n];

	public static void main(String[] asdf){
		subset(n,0,0);
	}

	public static void subset(int n, int dataIndex, int setIndex){

		if(dataIndex==n){
			for(int i=0; i<setIndex; i++)
				System.out.print(set[i]);
			System.out.println();
			return ;
		}

		set[setIndex] = dataIndex;

		subset(n, dataIndex+1, setIndex+1);
		subset(n, dataIndex+1, setIndex);
	}

}