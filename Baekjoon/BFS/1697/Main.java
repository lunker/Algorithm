import java.util.*;
import java.lang.Math;

public class Main{

  public static int N=0;
  public static int K=0;

  public static int[][] G=null;
  public static ArrayList<Integer>[] aList=null;

  public static int[] dist=null;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);
    N=s.nextInt();
    K=s.nextInt();

    G=new int[100001][100001];
    aList=new ArrayList[100000];
    // dist=new int[100001];

    for(int i=0;i<=100000;i++)
      dist[i]=Integer.MAX_VALUE;

    // dist[N]=0;

    make(N);
    traverse(N);

    System.out.println(dist[K]);
  }// end method

  public static void make(int here){

    if(here*2<=100000){
      G[here][here*2]=1;
      make(here*2);
    }
    if(here+1<=100000){
      G[here][here+1]=1;
      make(here+1);
    }

    if(here-1>=0){
      G[here][here-1]=1;
      make(here-1);
    }
  }

  public static void traverse(int here){

    for(int there=0;there<=100000;there++){
      if(G[here][there]==1){
        if(dist[there]>dist[here]+1){
          dist[there]=dist[here]+1;
          traverse(there);
        }
      }
    }

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
