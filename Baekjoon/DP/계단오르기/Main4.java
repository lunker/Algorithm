import java.util.*;
import java.lang.Math;

public class Main4{

  public static int[] cache=null;
  public static int[] value=null;
  public static boolean[] visited=null;

  public static int N=0;
  public static long MAX=Long.MIN_VALUE;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    N=s.nextInt();

    value=new int[N+1];
    visited=new boolean[N+1];

    for(int n=1;n<=N;n++)
      value[n]=s.nextInt();

    value[0]=0;
    go(1,0);
    go(2,0);
    System.out.println(MAX);
  }// end method

  public static void go(int idx, int sum){

    if(idx>N)
      return ;
    if(idx==N){
      //d 계산
      if(MAX<sum+value[idx])
        MAX=sum+value[idx];
      return;
    }

    visited[idx]=true;
    if(!visited[idx-1]){
      go(idx+1, sum+value[idx]);
      go(idx+2, sum+value[idx]);
    }
    else
      go(idx+2, sum+value[idx]);
    visited[idx]=false;
  }


}
