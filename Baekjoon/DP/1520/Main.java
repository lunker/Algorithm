import java.util.*;
import java.lang.Math;

public class Main{

  public static int[][] G=null;
  public static int[][] cache=null;

  public static Direction[] dirs=null;

  public static int M=0;//row
  public static int N=0;//col

  public static int cases=0;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    M=s.nextInt();
    N=s.nextInt();

    G=new int[M+2][N+2];
    cache=new int[M+2][N+2];

    dirs=new Direction[4];
    dirs[0]=new Direction(-1,0);
    dirs[1]=new Direction(1,0);
    dirs[2]=new Direction(0,-1);
    dirs[3]=new Direction(0,1);

    for(int row=0;row<=M+1;row++){
      for(int col=0;col<=N+1;col++){
        G[row][col]=Integer.MIN_VALUE;
        cache[row][col]=-1;
      }
    }// initialize

    for(int row=1;row<=M;row++){
      for(int col=1;col<=N;col++){
        G[row][col]=s.nextInt();
      }
    }// initialize
    // cache[M][N]=0;

    System.out.println(go(M,N));

  }// end method

  public static int go(int row, int col){

    if(cache[row][col]!=-1)
      return cache[row][col];

      /*
    if(row<=0||col<=0||row>=M+1||col>=N+1)
      return cache[row][col]=0;
        */

      // 시작점
    if(row==1&&col==1){
      return cache[row][col]=0;
    }
    else if(row==2&&col==1){
      if(G[row][col]<G[row-1][col])
        cache[row][col]=1;
      else
        cache[row][col]=0;
      return cache[row][col];
    }
    else if(row==1&&col==2){
      if(G[row][col]<G[row][col-1])
        cache[row][col]=1;
      else
        cache[row][col]=0;
      return cache[row][col];
    }

    int ret=0;
    if(G[row][col]<G[row-1][col]){
      ret+=go(row-1,col);
    }
    if(G[row][col]<G[row][col-1]){
      ret+=go(row,col-1);
    }

    return cache[row][col]=ret;
  }// end method
}// end class

class Direction{
  int x;
  int y;

  public Direction(int x, int y){
    this.x=x;
    this.y=y;
  }

  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
}
