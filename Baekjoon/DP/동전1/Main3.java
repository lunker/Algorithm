import java.util.*;
import java.lang.Math;

public class Main2{

  public static int[] cache=null; // k원을 만들기 위해 필요한 동전의 최소 수
  public static int[] coin=null; // 동전
  public static int N=0;
  public static int count=0;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    N=s.nextInt();
    int K=s.nextInt();

    coin=new int[N];
    for(int n=0;n<N;n++)
      coin[n]=s.nextInt();

    make(0,K);
    System.out.println(count);
  }// end method

  //동전 한개를 선택함.
  public static void make(int start, int k){
    if(k<0)
      return ;
    if(k==0){
      count++;
      return ;
    }
    for(int i=start;i<N;i++){
      make(i, k-coin[i]);
    }
  }// end method
}
