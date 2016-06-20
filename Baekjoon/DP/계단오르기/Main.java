import java.util.*;
import java.lang.Math;

public class Main{

  public static long[] cache=null;
  public static int[] stairs=null;

  public static int N=0;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    N=s.nextInt();

    stairs=new int[N];
    cache=new long[N];

    for(int n=0;n<N;n++)
      stairs[n]=s.nextInt();

    for(int n=0;n<N;n++)
      cache[n]=-1;

    System.out.println(climb(N-1));
  }// end method

  public static long climb(int N){

    if(cache[N]!=-1)
      return cache[N];

    if(N==0){
      return cache[N]=stairs[N];
    }
    else if(N==1){
      return cache[N]=stairs[N-1]+stairs[N];
    }
    else if(N==2){
      return cache[N]=Math.max(stairs[N-1], stairs[N-2])+stairs[N];
    }

    return cache[N]=Math.max(climb(N-2)+stairs[N],climb(N-3)+stairs[N-1]+stairs[N]);
  }// end method

}// end class
