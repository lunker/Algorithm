import java.util.*;
import java.lang.Math;

public class Main{

  public static long[] cache=null;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);
    int N=s.nextInt();
    cache=new long[N+1];
    for(int n=1;n<=N;n++)
      cache[n]=-1;

    System.out.println(pinary(N));

  }// end method

  public static long pinary(int N){
    long ret=0;

    ret=cache[N];
    if(ret!=-1)
      return ret;
    if(N==1)
      return cache[N]=1;
    if(N==2)
      return cache[N]=1;

    return cache[N]=pinary(N-1)+pinary(N-2);
  }// end method
}
