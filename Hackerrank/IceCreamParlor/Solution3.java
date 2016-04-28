import java.util.*;

public class Solution3{

  public static int[] c=null;

  public static void main(String[] params){

    Scanner scanner=new Scanner(System.in);

    int T=scanner.nextInt();

    for(int t=0;t<T;t++){

      int M=scanner.nextInt();
      int N=scanner.nextInt();
        c=new int[N+1];

        for(int n=1;n<=N;n++){
            c[n]=scanner.nextInt();
        }
        find(N,M);
    }
  }// end method

  public static void find(int N, int M){

    for(int first=1;first<=N;first++){
      for(int second=first;second<=N;second++){
        if(first!=second&& c[first]+c[second]==M){
          System.out.println(first+" "+second);
        }
      }// end inner
    }// end outter
  }// end method
}
