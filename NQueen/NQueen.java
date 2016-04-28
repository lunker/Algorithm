import java.util.Scanner;



public class NQueen{


	static Scanner scanner = new Scanner(System.in);
	static int testCases = -1;

	static boolean[][] isVisited = null;
	static int count = 0 ;
	public static void main(String[] asdf){

		testCases = scanner.nextInt();
		scanner.nextLine();
		int[] inputs = new int[testCases];
		for(int i=0; i<testCases; i++){
			inputs[i] = scanner.nextInt();
		}

		for(int i=0; i<testCases;i++){
			isVisited = new boolean[inputs[i]][inputs[i]];
			System.out.println(makeChess(inputs[i], 0));
		}
	}

	public static int makeChess(int n, int currentLine){

		int count = 0;
		for(int i=0; i<n; i++){
			// 아직 방문하지 않았을때, 

			if(isVisitable(n, currentLine, i)){

				if(currentLine == n-1){
					
					return 1;
				}

				isVisited[currentLine][i] = true;
				count += makeChess(n,currentLine+1);
				isVisited[currentLine][i] = false;
			}
			/*
			if( isVisited[currentLine][i] == false){
				if(currentLine == n-1){
					count++;
					return 1;
				}
				else{
					visit(n, currentLine, i, true);
					makeChess(n, currentLine+1);/////////
					visit(n, currentLine, i, false);		
				}
			}//end if 
			*/
		}// end for

		return count;
	}

	public static boolean isVisitable(int size, int row, int col){
		int x = row;
		int y = col;

			//동서남북 
			while(x>=0){
				if(isVisited[x--][y] == true)
					return false;
			}
			x = row;

			while(y>=0){
				if(isVisited[x][y--] == true)
					return false;
			}
			y = col;

			while(x<size){
				if(isVisited[x++][y] ==true)
					return false;
			}
			x = row;

			while(y<size){
				if(isVisited[x][y++] == true)
					return false;
			}
			y = col;

			//NE
			while(x>=0 && y<size){
				if(isVisited[x--][y++] == true)
					return false;
			}
			x = row;
			y = col;

			// ES
			while(x<size && y<size){
				if(isVisited[x++][y++] == true)
					return false;
			}
			x=row;
			y=col;

			while(x<size && y >=0){
				if(isVisited[x++][y--] == true)
					return false;
			}
			x=row;
			y=col;

			while(x>=0 && y>=0){
				if(isVisited[x--][y--] == true)
					return false;
			}

			return true;

	}
	public static void visit(int size, int row, int col, boolean visit){
		// welcome to visit
			int x = row;
			int y = col;

			//동서남북 
			while(x>=0){
				isVisited[x--][y] = visit;
			}
			x = row;

			while(y>=0){
				isVisited[x][y--] = visit;
			}
			y = col;

			while(x<size){
				isVisited[x++][y] = visit;
			}
			x = row;

			while(y<size){
				isVisited[x][y++] = visit;
			}
			y = col;


			//NE
			while(x>=0 && y<size){
				isVisited[x--][y++] = visit;
			}
			x = row;
			y = col;

			// ES
			while(x<size && y<size){
				isVisited[x++][y++] = visit;
			}
			x=row;
			y=col;

			while(x<size && y >=0){
				isVisited[x++][y--] = visit;
			}
			x=row;
			y=col;

			while(x>=0 && y>=0){
				isVisited[x--][y--] = visit;
			}

		}// end method

}