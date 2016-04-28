



public class BFS{

	static int n = 12;

	static int[][] graph = {
		{0,1,1,1,0,0,0,0,0,0,0,0},//0
		{1,0,0,1,1,1,0,0,0,0,0,0},//1
		{1,0,0,0,0,0,0,1,0,0,0,0},//2
		{1,1,0,0,0,0,1,0,1,0,0,0},//3
		{0,1,0,0,0,0,0,0,0,0,0,1},//4
		{0,1,0,0,0,0,0,0,0,0,0,0},//5
		{0,0,0,1,0,0,0,1,0,0,1,0},//6
		{0,0,1,0,0,0,1,0,0,0,0,0},//7
		{0,0,0,1,0,0,0,0,0,1,0,0},//8
		{0,0,0,0,0,0,0,0,1,0,0,0},//9
		{0,0,0,0,0,0,1,0,0,0,0,0},//10
		{0,0,0,0,1,0,0,0,0,0,0,0},//11
	  // 0,1,2,3,4,5,6,7,8,9,10,11
	};

	// static boolean[][] visited = new boolean[n][n];
	
	static int[] distance = new int[n];

	static int[] queue = new int[n+1];
	static int front = -1;
	static int rear = 0;


	static int[] visitedOrderStack = new int[n];
	static int top =0;
	static boolean[] visited = new boolean[n];

	public static void main(String[] asdf){

		bfsDistance(0);

		// show result
		// System.out.println("(0) ~ (1) : " + distance[1]);
		// System.out.println("(0) ~ (2) : " + distance[2]);
		// System.out.println("(0) ~ (3) : " + distance[3]);
		// System.out.println("(0) ~ (4) : " + distance[4]);
		// System.out.println("(0) ~ (5) : " + distance[5]);
		// System.out.println("(0) ~ (6) : " + distance[6]);

		for(int i=0; i<n; i++){
			System.out.println("distance 0 ~ " + i + ":"+distance[i]);
		}
	}	

	public static void bfs(int location){

		if(rear == n){
			return ;
		}
		/*
		if(rear - front == 1){
			// empty
			// end bfs
			return;
		}
		*/

		/*
		visited[location] = true;

		// 인접한 정점을 큐에 추가 
		for(int row=0; row<n; row++){
			if( graph[location][row] == 1 && !visited[row]){
				// visited[row] = true;
				queue[rear++] = row;
				if(distance[row] < distance[location]+1)
					distance[row] = distance[location]+1;
			}
		}
		*/

		// 
		int searchTargetNode = queue[++front];
		bfs(searchTargetNode);

	}
	public static void bfs2(int start){

		visited[start]=true;
		queue[rear++]=start;

		while(rear!=n || front!=n-1){

			int here = queue[++front];
			visitedOrderStack[top++] = here;
			visited[here]=true;

			for(int i=0; i<n; i++){
				if(graph[here][i]==1 && !visited[i]){
					visited[i]=true;
					queue[rear++]=i;
				}
			}// end for 
		}
	}// end bfs2

	public static void bfsDistance(int start){

		visited[start]=true;
		queue[rear++]=start;
		distance[start] = 0;

		while(rear!=n || front!=n-1){

			int here = queue[++front];
			visitedOrderStack[top++] = here;
			visited[here]=true;

			for(int i=0; i<n; i++){
				if(graph[here][i]==1 && !visited[i]){
					visited[i]=true;
					queue[rear++]=i;
					distance[i] = distance[here]+1;
				}
			}// end for 
		}
	}
}
