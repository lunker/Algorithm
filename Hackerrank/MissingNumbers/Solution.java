import java.util.*;

public class Solution{

  public static int[] A=null;
  public static int[] B=null;
  public static int[] missing=null;
  public static int MAX_NUM=10000;

  public static void main(String[] params){

    Scanner scanner=new Scanner(System.in);

    A=new int[MAX_NUM];
    B=new int[MAX_NUM];
    missing=new int[MAX_NUM];

    int N=scanner.nextInt();

    for(int n=0;n<N;n++){
      A[scanner.nextInt()]++;
    }

    int M=scanner.nextInt();
    for(int m=0;m<M;m++)
      B[scanner.nextInt()]++;

    solve(N,M);

  }// end method
  public static void solve(int N, int M){
    int large=0;
    int small=0;

    if(N>M){
      large=N;
      small=M;
    }
    else{
      large=M;
      small=N;
    }

    for(int idx=0;idx<MAX_NUM;idx++){
      if(A[idx]!=B[idx]){
        System.out.print(idx+" ");
      }
    }

  }
}
