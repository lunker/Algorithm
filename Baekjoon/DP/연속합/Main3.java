import java.util.*;
import java.lang.Math;

public class Main3{

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
    }

    maxSum(0);
    System.out.println(MAX);

    /*
    boolean isNeg=true;

    for(int n=0;n<N;n++){
      arr[n]=s.nextInt();
      if(arr[n]>0)
        isNeg=false;
    }

    if(isNeg){
      int max=Integer.MIN_VALUE;

      for(int idx=0;idx<N;idx++){
          if(max<arr[idx])
            max=arr[idx];
      }
      System.out.println(max);
    }
    else{
        maxSum(0);
        System.out.println(MAX);
    }
    */
    maxSum(0);
    System.out.println(MAX);
  }// end method

  public static void maxSum(int from){

    if(from==N)
      return ;

    long sum=0;
    int next=N-1;
    for(int idx=from;idx<N;idx++){
      sum+=arr[idx];
      if(arr[idx]<0){
        sum-=arr[idx];
        next=idx;
        break;
      }
    }

    if(MAX<sum)
      MAX=sum;

    maxSum(next+1);
  }// end method
}
