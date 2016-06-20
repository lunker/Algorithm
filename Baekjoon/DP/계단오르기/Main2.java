import java.util.*;
import java.lang.Math;

public class Main2{

  public static int[] cache=null;
  public static int[] value=null;
  public static boolean[] visited=null;


  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    int N=s.nextInt();
    cache=new int[N+1];
    value=new int[N+1];
    visited=new boolean[N+1];

    for(int n=1;n<=N;n++)
      value[n]=s.nextInt();

    for(int n=0;n<=N;n++)
      cache[n]=-1;

    value[0]=0;
    cache[0]=0;// 시작점

    System.out.println(go(N));
  }// end method

  public static int go(int N){
    // base
    if(cache[N]!=-1)
      return cache[N];

    if(N==1||N==2){
      return cache[N]=value[N];
    }

    if(go(N-2)>go(N-1)){
      cache[N]=go(N-2)+value[N];
      visited[N]=true;
    }
    else{
      // N-1을 가야 하는데
      if(visited[N-1]){
        cache[N]=go(N-2)+value[N];
        visited[N-2]=true;
      }
      else{
        cache[N]=go(N-1)+value[N];
        visited[N-1]=true;
      }
    }

    return cache[N];
  }// end method

}
