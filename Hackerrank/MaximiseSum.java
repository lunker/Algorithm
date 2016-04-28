

public class MaximiseSum{

  public static int[] arr=null;
  public static int[] pSum=null;


  public static void main(String[] params){

    Scanner scanner = new Scanner(System.in);

    int T = scanner.nextInt();

    for(int i=0; i<T; i++){

       int N = scanner.nextInt();
       int M = scanner.nextInt();

       arr=new int[N];
       pSum=new int[N];

       for(int idx=0; idx<N; idx++){
           arr[idx] = scanner.nextInt();
       }
       pSum[0]=arr[0];
       System.out.println(maximise(N,M));

    }// end total cases
  }// end method

  public static int maximise(int N, int M){
    int max=Integer.MIN_VALUE;

    //  부분합계산
    for(int idx=0;idx<N-1;idx++){
      pSum[idx+1]=pSum[idx]+arr[idx+1];
    }

    // 최대치 계산
    for(int start=0;start<N;start++){
      for(int end=start;end<N;end++){

        if(start==0){
          if( max < (pSum[end])%M )
            max=(pSum[end])%M;
        }
        else{
          if( max < (pSum[end]-pSum[start-1])%M )
            max=(pSum[end]-pSum[start-1])%M;
        }
      }
    }

    return max;
  }// end method
}
