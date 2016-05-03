import java.util.*;

public class MakeOne{

  public static int[] cache=null;

  public static void main(String[] params){

    Scanner s=new Scanner(System.in);

    int N=s.nextInt();
    cache=new int[N];
    for(int n=0;n<N;n++)
      cache[n]=-1;

    cache[1]=0;
    cache[2]=1;
    cache[3]=1;
    cache[4]=2;

    System.out.println(make(N));

  }
  public static int make(int n){

    int ret=0;

    ret=cache[n];
    if(ret!=-1)
      return ret;

    if(n%3==0){
      cache[n]=(make(n/3)+1);
    }
    else if(n%2==0){
      cache[n]=make(n/2)+1;
      //return
    }
    else{
      cache[n]=make(n-1)+1;
    }
    return cache[n];
  }

}
