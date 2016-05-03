import java.util.*;
import java.lang.Math;

public class Main{

  public static int[] cache=null;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    int N=s.nextInt();
    cache=new int[N+1];
    for(int n=0;n<=N;n++)
      cache[n]=-1;
    cache[1]=0;

    System.out.println(make(N));
  }// end method

  public static int make(int n){

    int ret=0;

    ret=cache[n];
    if(ret!=-1)
      return ret;

    if(n%3==0){
      cache[n]= Math.min(make(n/3), make(n-1))+1;
    }
    else if(n%2==0){
      cache[n]=Math.min(make(n/2), make(n-1))+1;
    }
    else{
      cache[n]=make(n-1)+1;
    }
    return cache[n];
  }

}
