import java.util.*;

public class Solution{

  public static int[] c=null;
  public static int[] tmpC=null;

  public static void main(String[] params){

    Scanner scanner=new Scanner(System.in);

    int T=scanner.nextInt();
    int M=scanner.nextInt();
    int N=scanner.nextInt();

    for(int t=0;t<T;t++){
        c=new int[N+1];
        tmpC=new int[N+1];

        for(int n=1;n<=N;n++){
            c[n]=scanner.nextInt();
            tmpC[n]=c[n];
        }

        sort(1,N);


        for(int i=1;i<=N;i++)
            System.out.print(tmpC[i]+" ");

        find(N,M);
    }
  }

  // merge sort
  public static void sort(int start,int end){

    if(start==end)
      return ;

    // left
    sort(start, start+(end-start)/2);
    // right
    sort(start+(end-start)/2+1, end);

    merge(start, start+(end-start)/2 ,end );
  }// end method

  // 병합?
  public static void merge(int start, int mid, int end){

    // start ~ end 까지의 배열을 arrange

    int tmp=0;
    int leftIdx=start;
    int rightIdx=mid+1;

    // 두 개의 배열 merge
    while(leftIdx<=mid&&rightIdx<=end){
      if(tmpC[leftIdx]<tmpC[rightIdx]){
        leftIdx++;
      }
      else if(tmpC[leftIdx]>tmpC[rightIdx]){
        tmp=tmpC[rightIdx];
        tmpC[rightIdx]=tmpC[leftIdx];
        tmpC[leftIdx]=tmp;
        rightIdx++;
      }
      else
        rightIdx++;
    }
  }// end method

  public static void find(int N,int M){

    for(int me=1;me<=N;me++){
      int myCost=tmpC[me];
      int yourCostIdx= bSearch(tmpC, 1,N,M-myCost);
      if(yourCostIdx!=-1){

          int realMe = getIdx(myCost, -1, N);
          int realU = getIdx(tmpC[yourCostIdx], realMe, N);

        //int realMe=bSearch(c,1,N,myCost);
       // int realU=bSearch(c,1,N,tmpC[yourCostIdx]);
          System.out.println(realMe +" "+realU);
        return ;
      }
    }
  }// end method

    public static int getIdx(int val, int prev, int N){
        for(int n=1;n<=N;n++){
            if(c[n]==val&& c[n]!=prev){
                return n;
            }
        }
        return -1;
    }

    // find target from start to end (1~N)
    // return index in c[]
  public static int bSearch(int[] targetArr, int start, int end, int target){

    if(start==end)
      return -1;

    int mid= start+(end-start)/2;

    if(targetArr[mid]<target)
      return bSearch(targetArr,mid+1,end,target);
    else if(targetArr[mid]==target)
      return mid;
    else
      return bSearch(targetArr,start,mid-1,target);
  }


}
