public class DFS{


	// 6x6
	static int[][] graph = {

		{0,1,0,0,1,0},
		{1,0,1,1,1,1},
		{0,1,0,0,0,1},
		{0,1,0,0,0,0},
		{1,1,0,0,0,0},
		{0,1,1,0,0,0}

	};
	static boolean[] visited = new boolean[6];
	static int n = 6;

	public static void main(String[] asf){
		dfs(0);
	}
	public static void dfs(int current){

		visited[current]= true;	
		System.out.print(current);
		for(int i=0; i<n; i++){
			if( graph[current][i]==1 && !visited[i]){
				dfs(i);
			}
		}
	}



}