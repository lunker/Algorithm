import java.util.*;
import java.lang.Math;

public class Main{

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


    // sort();
    make(N-1,K);
    System.out.println(count);
  }// end method

/*
  public static void sort(){
    int tmp=0;
    for(int cnt=0;cnt<N-1;cnt++){
      for(int idx=0;idx<N-cnt-1;idx++){
        if(coin[idx]>coin[idx+1]){
          tmp=coin[idx];
          coin[idx]=coin[idx+1];
          coin[idx+1]=tmp;
        }
      }
    }
  }// end method
*/


  //동전 한개를 선택함.
  public static void make(int idx, int k){

    if(k==0){
      count++;
      return ;
    }

    for(int item=idx;item>=0;item--){
      if(k-coin[item]>=0)
        make(item,k-coin[item]);
    }
  }// end method
}
