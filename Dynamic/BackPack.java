public class BackPack{

	static int n = 6;
	static int maxWeight = 10;

	static int[] weight={4,2,6,4,2,10};
	static int[] value={7,10,6,7,5,4};

	static boolean[] isTake = new boolean[n];

	static int sumW = 0;
	static int sumV = 0;
	public static void main(String []asdf){

		pack(0);
	}

	public static void pack(int count){

		if(count == n){
			for(int i=0; i<n; i++){
				if(isTake[i]== true ){
					if((sumW+weight[i] < maxWeight))
						sumW += weight[i];
					else 
						return;
				}
			}

			for(int i=0; i<n; i++)
				{
					if (isTake[i]) {
						System.out.print(i);
					}
				}
			System.out.println();
			return;
		}

		isTake[count] = true;
		pack(count+1);
		isTake[count] = false;
		pack(count+1);
	}


}