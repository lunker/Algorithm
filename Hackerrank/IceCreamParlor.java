

public class IceCreamParlor{

  public static int[] c=null;

  public static void main(String[] params){

    Scanner scanner=new Scanner(System.in);

    int T=scanner.nextInt();
    int M=scanner.nextInt();
    int N=scanner.netInt();

    c=new int[N+1];
    for(int n=1;n<=N;n++)
      c[n]=scanner.nextInt();

    sort(0,N-1,N);
    find(N,M);
  }

  // merge sort
  public static void sort(int start,int end){

    if(start==end)
      return ;

    // left
    sort(start, (end-start)/2);
    // right
    sort((end-start)/2, end);

    merge(start, (end-start)/2 ,end );

  }// end method

  // 병합?
  public static void merge(int start, int mid, int end){

    // start ~ end 까지의 배열을 arrange

    int tmp=0;
    int leftIdx=start;
    int rightIdx=mid+1;

    // 두 개의 배열 merge
    while(leftIdx<=mid&&rightIdx<=end){
      if(c[leftIdx]<c[rightIdx]){
        leftIdx++;
      }
      else if(c[leftIdx]>c[rightIdx]){
        tmp=c[rightIdx];
        c[rightIdx]=c[leftIdx];
        c[leftIdx]=tmp;
        rightIdx++;
      }
      else
        rightIdx++;
    }
  }// end method

  public static void find(int N,int M){

    for(int me=1;me<=N;me++){
      int myCost=c[me];
      int yourCostIdx= bSearch(1,N,M-myCost);
      if(yourCostIdx!=-1){
        System.out.println(me+" "+yourCostIdx);
        return ;
      }
    }
  }// end method

  // return index in c[]
  public static int bSearch(int start, int end, int target){

    if(start==end)
      return -1;
    int mid=(end-start)/2;
    if(c[mid]<target)
      bSearch(mid+1,end,target);
    else if(c[mid]==target)
      return mid;
    else
      bSearch(start,mid-1,target);

  }

}
