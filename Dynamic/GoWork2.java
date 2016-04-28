


/**

	map : 출발지 (0,0) ~ 도착지(w,h)에 이르는 길을 나타낸다.
	Q. 여기에서 출발지 ~ 도착지에 갈 수 있는 길의 수를 찾아라.
	
*/

public class GoWork2{

	static int[][] map={

		{1,1,1,1,1},
		{1,1,0,0,1},
		{1,1,1,1,1},
		{1,1,1,0,1},
		{0,0,1,1,1},

	};
	static int w = 5;
	static int h = 5;
	static int[][] table = new int[5][5];

	public static void main(String[] asds){
		System.out.println("result;"+search(h-1,w-1));
	}

	public static int search(int row, int col){

		if(row == 0 || col == 0)
			return map[row][col];

		if(row > 0 && col > 0){
			if(map[row][col] ==0)
				return 0;
			else
				return search(row-1,col) + search(row,col-1);
		}
		else
			return 0;
	}




}