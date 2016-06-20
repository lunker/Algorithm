ldk2011208import java.util.*;
import java.lang.Math;

public class Main{

  public static long[] cache=null;
  public static int[] arr=null;

  public static int N=0;
  public static long MAX=Long.MIN_VALUE;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);
    N=s.nextInt();
    cache=new long[N];
    arr=new int[N];

    for(int n=0;n<N;n++){
      arr[n]=s.nextInt();
      cache[n]=-1;
    }

    System.out.println(max(N-1));

  }// end method

  public static long max(int N){

    if(cache[N]!=-1)
      return cache[N];

    if(N==0)
      return cache[N]=arr[N];
    else if(N==1){
      return cache[N]=Math.max(arr[N-1],arr[N-1]+arr[N]);
    }
    else if(N==2){
      return cache[N]= Math.max(Math.max(arr[N],arr[N-1]+arr[N-2]+arr[N]), arr[N]+arr[N-1]);
    }

    if(max(N-1)!=max(N-2)){
      // return cache[N]=Math.max(Math.max(max(N-1)+arr[N], max(N-1)),arr[N]);
      return cache[N]=Math.max(max(N-1),max(N-1)+arr[N]);
    }
    else{
      return cache[N]=Math.max(arr[N-2]+arr[N-1]+arr[N], arr[N]);
    }

    // else{
    //   int tmp =Math.max(Math.max(arr[N-2]+arr[N-1]+arr[N], arr[N-1]+arr[N]),arr[N]);
    //   return cache[N]=Math.max(tmp,max(N-1));
    // }
  }// end method
}
