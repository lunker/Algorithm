public class Maze{



	static int[][] map = {

		{1,1,1,0,0},
		{1,1,1,1,0},
		{0,0,1,1,1},
		{0,0,1,0,1},
		{1,1,1,1,1}

	};

	static int n = 5;
	static boolean[][] visited = new  boolean[n][n];
	static String[] stack = new String[2*n];
	static int top=0;

	public static void main(String[] asdf){


		System.out.println(search(0,0));
		for(int i=0; i<top;i++)
			System.out.println(stack[i]);
	}

	public static boolean search(int y, int x){

		if(y==n-1 && x==n-1){
			if(map[y][x]==1 && !visited[y][x])
				return true;
			else
				return false;
		}
		if( y>=n || x>=n){
			// top--;
			return false;
		}
		if(map[y][x]==1 && !visited[y][x]){
			visited[y][x]=true;
			stack[top++]="("+x+","+y+")";
			return search(y+1,x) || search(y,x+1);
		}
		else{
			return false;
		}



	}
}