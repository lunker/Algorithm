import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Knapsack {

  public static int[] arr=null;
  public static int[] val=null;
  public static int min=Integer.MAX_VALUE;
  public static int N=0;
  public static int K=0;

  public static void main(String[] params){

    Scanner s = new Scanner(System.in);

    int T=s.nextInt();
    for(int t=0;t<T;t++){
      N=s.nextInt();
      K=s.nextInt();

      arr=new int[N];
      val=new int[K+1];

      // 기대치 초기화
      for(int k=0;k<=K;k++){
        val[k]=-1;
      }
      val[0]=1;
      for(int n=0;n<N;n++){
          arr[n]=s.nextInt();
          if(min>arr[n])
              min=arr[n];

          if(K>=arr[n])
             val[arr[n]]=1;
      }
      for(int i=0;i<=min;i++){
          if(K-i>=0)
              pick(K-i);
      }

      for(int k=K;;k--){
        if(val[k]==1){
          System.out.println(k);
          break;
        }
      }// end loop
    }
  }// end method

  public static int pick(int k){

    if(val[k]!=-1)
      return val[k];

    int result=0;
    for(int idx=0;idx<N;idx++){
      if(k-arr[idx]>=0){
        result = result | pick(k-arr[idx]);
        if(result==1)
          break;
      }
    }// end for

    return val[k]= result;
  }// end method
}
