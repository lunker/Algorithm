import java.util.*;
import java.lang.Math;

public class Main{

  public static int[] wine=null;

  public static void main(String[] para){
    Scanner s=new Scanner(System.in);
    int N=s.nextInt();

    wine=new int[N];
    for(int n=0;n<N;n++){
      wine[n]=s.nextInt();
    }
    System.out.println(max(N-1));
  }// end method

  public static long max(int N){

    if(N==0)
      return wine[N];
    if(N==1)
      return wine[N-1]+wine[N];

    return Math.max(max(N-2)+wine[N],max(N-1));
  }
}
