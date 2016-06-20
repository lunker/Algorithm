

import java.util.*;

public class Main{

  public static int N=0;
  public static int M=0;
  public static int[][] maze=null;
  public static int[][] aM=null;

  public static int[] distance=null;


  public static void main(String[] para){

    Scanner s=new Scanner(System.in);

    N=s.nextInt();
    M=s.nextInt();
    maze=new int[N+2][M+2];
    aM=new int[N*M][N*M];

    distance=new int[N*M];
    for(int n=1;n<=N;n++){
      for(int m=1;m<=M;m++)
        maze[n][m]=s.nextInt();
    }


    BFS(1);
    System.out.println();
  }// end method

  public static void trans(){
    for(int n=1;n<=N;n++){
      for(int m=1;m<=M;m++){
        if(maze[n][m]==1){

            if(maze[n-1][m]==1){
              aM[N*(n-1)+m][N*(n-1-1)+m]=1;
            }
            else if(maze[n][m-1]==1){
              aM[N*(n-1)+m-1][N*(n-1)+m-1]=1;
            }
            else if(maze[n+1][m]==1){
              aM[N*(n-1)+m][N*(n)+m]=1;
            }
            else if(maze[n][m+1]==1){
              aM[N*(n-1)+m][N*(n-1)+m+1]=1;
            }
        }
      }
    }// end outter
  }// end method

  public static void BFS(int start){
    LinkedList<Integer> queue=new LinkedList<Integer>();

    queue.add(start);
    distance[1]=0;

    while(!queue.isEmpty()){

      int here=queue.poll();

      for(int there=0;there<N*M;there++){

      }

    }

  }
}
