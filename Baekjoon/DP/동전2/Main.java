import java.util.*;
import java.lang.Math;

public class Main{

  public static int[] cache=null; // k원을 만들기 위해 필요한 동전의 최소 수
  public static int[] coin=null; // 동전
  public static int N=0;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    N=s.nextInt();
    int K=s.nextInt();

    coin=new int[N+1];
    cache=new int[K+1];
    for(int k=0;k<=K;k++)
      cache[k]=Integer.MAX_VALUE;

    for(int n=1;n<=N;n++){
      coin[n]=s.nextInt();
      if(coin[n]<=K)
        cache[coin[n]]=1;
    }

    int result=make(K);
    if(result==Integer.MAX_VALUE)
      System.out.println("-1");
    else
      System.out.println(result);
  }// end method

  public static int make(int K){

    int ret=0;
    ret=cache[K];

    if(ret!=Integer.MAX_VALUE)
      return ret;

    for(int c=N;c>=1;c--){
      if(K-coin[c]>0){
        if(ret>make(K-coin[c]))
          ret=make(K-coin[c]);
      }
    }

    if(ret!=Integer.MAX_VALUE)
      cache[K]=ret+1;
    else
      cache[K]=ret;
    return cache[K];
  }// end method
}
