
/**
	map : 각 길에서 누릴 수 있는 즐거움.
	Q. 시작점 (0,0) 에서 도착지점(4,4)까지 최단경로로 이동할때, 가능한 최대의 즐거움은 ?
	A. 22
*/

public class GoWorkWithHappy{


	static int[][] map={
		{1,2,2,1,5},
		{1,4,4,3,1},
		{2,1,1,1,2},
		{1,3,5,1,1},
		{1,5,1,2,2},

	};
	static int w = 5;
	static int h = 5;


	public static void main(String[] asdasd){


		System.out.println("result ; " + search3(0,0));
	}

	public static int search(int x, int y){

		// 시작점에 도달
		if(x == 0 && y == 0){
			return map[0][0];
		}
		if( x > 0 && y > 0){
			if(map[x-1][y] > map[x][y-1]){
				return map[x][y] + search(x-1,y);
			}
			else{
				return map[x][y] + search(x,y-1);
			}
		}
		else if(x == 0 ){
			return map[x][y] + search(x,y-1);
		}
		else if(y==0){
			return map[x][y] + search(x-1,y);
		}
		
		return 0;
	}

	public static int search2(int x, int y){
		System.out.println("x,y : " + x + ","+y  );
		//base case
		if(x==4 && y == 4){
			return map[4][4];
		}
		
		if(x==4){

			return map[x][y] + search2(x,y+1);
		}
		else if(y==4){
			return map[x][y] + search2(x+1,y);
		}

		if(map[x+1][y] > map[x][y+1]){
			return map[x][y] + search2(x+1,y);
		}
		// else if(map[x+1][y] < map[x][y+1]){
		// 	return map[x][y] + search(x,y+1);
		// }
		else{
			return map[x][y] + search2(x,y+1);
		}
	}

	public static int search3(int x, int y){

		
		if(x==4 && y==4){
			return map[x][y];
		}
		if(x==4){
			return map[x][y] + search3(x,y+1);
		}
		else if(y==4){
			return map[x][y] + search3(x+1,y);
		}
		else{
			return map[x][y] +  (  (search3(x+1,y) > search3(x,y+1)) ? search3(x+1,y) : search3(x,y+1)) ;
		}
	}// end method

	public static int searchRecur(int x, int y){

		;

	}
}