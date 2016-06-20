import java.util.*;
import java.lang.Math;

public class Main3{

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
    go(1);
    System.out.println(MAX);
  }// end method

  public static void go(int idx){

    if(idx>N)
      return ;
    if(idx==N){
      //d 계산
      visited[N]=true;
      long tmp=0;
      for(int i=1;i<=N;i++){
        if(visited[i])
          tmp+=value[i];
      }
      if(MAX<tmp)
        MAX=tmp;
      visited[N]=false;
      return;
    }

    visited[idx]=true;
    if(!visited[idx-1]){
      go(idx+1);
      go(idx+2);
    }
    else
      go(idx+2);
    visited[idx]=false;
  }


}
