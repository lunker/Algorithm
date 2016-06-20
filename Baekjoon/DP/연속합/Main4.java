import java.util.*;
import java.lang.Math;

public class Main{

  public static long[] cache=null;
  public static int[] arr=null;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);
    int N=s.nextInt();
    cache=new long[N];
    arr=new int[N];

    for(int n=0;n<N;n++)
      arr[n]=s.nextInt();

      // 초기화
    cache[0]=arr[0];
    for(int n=1;n<N;n++){
        cache[n]=cache[n-1]+arr[n];
    }

    System.out.println(maxSum(N));
  }// end method

  public static long maxSum(int N){
    long max=Long.MIN_VALUE;

    for(int from=0;from<N;from++){
      for(int there=from;there<N;there++){
        if(arr[there]<0 || arr[from]<0)
          continue;
        if(from==0){
          if(max<cache[there])
            max=cache[there];
        }
        else{
          if(max<cache[there]-cache[from-1]){
            max=cache[there]-cache[from-1];
          }
        }
      }
    }// end for

    return max;
  }// end method
}
