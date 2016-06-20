import java.util.*;
import java.lang.Math;


// 완전탐색
public class Main2{

  public static int[][] G=null;
  public static Direction[] dirs=null;

  public static int M=0;//row
  public static int N=0;//col

  public static int cases=0;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    M=s.nextInt();
    N=s.nextInt();

    G=new int[M+2][N+2];

    dirs=new Direction[4];
    dirs[0]=new Direction(-1,0);
    dirs[1]=new Direction(1,0);
    dirs[2]=new Direction(0,-1);
    dirs[3]=new Direction(0,1);

    for(int row=0;row<=M+1;row++){
      for(int col=0;col<=N+1;col++){
        G[row][col]=-1;
      }
    }// initialize

    for(int row=1;row<=M;row++){
      for(int col=1;col<=N;col++){
        G[row][col]=s.nextInt();
      }
    }// initialize

    go(1,1);
    System.out.println(cases);

  }// end method

  public static void go(int row, int col){

    if(row==M&&col==N){
      cases++;
      return ;
    }

    for(int dir=0;dir<4;dir++){
      int nextX=dirs[dir].getX();
      int nextY=dirs[dir].getY();

      if(G[row+nextX][col+nextY]!=-1&&G[row][col]>G[row+nextX][col+nextY]){
        go(row+nextX,col+nextY);
      }
    }// end loop
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
