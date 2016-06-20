import java.util.*;
import java.lang.Math;

public class Main2{

  public static int N=0;
  public static int K=0;

  public static int[] dist=null;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);
    N=s.nextInt();
    K=s.nextInt();

    dist=new int[100001];

    for(int i=0;i<=100000;i++)
      dist[i]=Integer.MAX_VALUE;

    dist[N]=0;
    find(N);
    System.out.println(dist[K]);
  }// end method


  public static void find(int current){

    if(current>K||current<0)
      return ;

    if(current*2<=100000){
      if(dist[current*2]>dist[current]+1){
        dist[current*2]=dist[current]+1;
        find(current*2);
      }
    }//end outer
    if(current+1<=100000){
      if(dist[current+1]>dist[current]+1){
        dist[current+1]=dist[current]+1;
        find(current+1);
      }
    }
    if(current-1>=0){
      if(dist[current-1]>dist[current]+1){
        dist[current-1]=dist[current]+1;
        find(current-1);
      }
    }

  }// end method
}// END CLASS
