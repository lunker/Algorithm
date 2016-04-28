import java.util.*;


/*
  프림 알고리즘 사용.
  Priority Queue대신에... 다른거를 사용하면 어찌 되나 . . .?
*/
public class TSP1{

  public static int N=0;
  public static double[][] G=null;
  public static boolean[] visited=null;
  // public static Vertex[] minDist=null; // 현재 만들어진 tree에서 각 정점까지의 거리.
  public static double[] minDist=null; // 현재 만들어진 tree에서 각 정점까지의 거리.

  public static void main(String[] params){

    Scanner s= new Scanner(System.in);
    int C=s.nextInt();

    for(int c=0;c<C;c++){
      N=s.nextInt();
      G=new double[N+1][N+1];
      visited=new boolean[N+1];
      // minDist=new Vertex[N+1];
      minDist=new double[N+1];
      for(int idx=1;idx<=N;idx++){
        minDist[idx]=Double.MAX_VALUE;
      }
      /* 객체일 경우의 초기화
      for(int i=1;i<=N;i++){
        // minDist[i]=new double(i,0);
      }
      */

      s.nextLine();
      for(int n=0;n<N;n++){
        String[] str=null;
        str=s.nextLine().split(" ");

        for(int idx=0;idx<str.length;idx++){
          G[n+1][idx+1]= Double.parseDouble(str[idx]);
        }
      }// end initialize

      // 거리 초기화

      /*
      for(int idx=1;idx<=N;idx){
        if(G[1][idx]>0)
          minDist[idx].setDist(minDist[idx].getDist()+G[1][idx]);
      }
      */
      minDist[1]=0;
      for(int idx=1;idx<=N;idx++){
        if(G[1][idx]>0)
          minDist[idx] = minDist[1]+G[1][idx];
      }
      System.out.println(travel(1));

    }// end test case
  }

  public static double travel(int start){

    double dist=0;
    int minIdx=0;

    double prvMin=Double.MIN_VALUE;
    int here=start;
    visited[here]=true;

    // tree에 추가
    while(!isVisitAll()){
      double minVal=Double.MAX_VALUE;

      // find nearest vertext from minDist[]
      for(int idx=1;idx<=N;idx++){
        if( !visited[idx] && prvMin<minDist[idx] && minVal>minDist[idx]){
          minVal=minDist[idx];
          minIdx=idx;
        }
      }
      if(minVal==Double.MAX_VALUE)
        return 0;
      // cycle이 없을 경우
      if(!isCycle(here,minIdx)){

        //minDist[]갱신
        for(int there=1;there<=N;there++){
          // 추가한 정점과 인접한 놈들의 거리를 갱신
          if(G[minIdx][there]>0){
            if(minDist[there] < minDist[minIdx]+G[minIdx][there])
              minDist[there]=minDist[minIdx]+G[minIdx][there];
          }
        }
        //travel(there)
        return dist+=G[here][minIdx]+travel(minIdx);
      }
      prvMin=minVal;
    }// end while

    return dist;
  }// end method

  public static boolean isVisitAll(){
    boolean result=true;

    for(int idx=1;idx<=N;idx++)
      result=result&visited[idx];
    return result;
  }
  public static boolean isCycle(int here, int there){
    if(visited[here]&&visited[there])
      return true;
    else
      return false;
  }
}// end class

class Vertex{
  int num;
  double dist;

  public Vertex(int num, double dist){
    this.num=num;
    this.dist=dist;
  }

  public int getNum(){
    return num;
  }
  public double getDist(){
    return dist;
  }
  public void setDist(double dist){
    this.dist=dist;
  }
}
