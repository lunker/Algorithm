import java.util.*;

public class Solution2{

  public static int[] c=null;

  public static void main(String[] params){

    Scanner scanner=new Scanner(System.in);

    int T=scanner.nextInt();
    int M=scanner.nextInt();
    int N=scanner.nextInt();

    for(int t=0;t<T;t++){
        c=new int[N+1];

        for(int n=1;n<=N;n++){
            c[n]=scanner.nextInt();
        }

        // 1~N
        mergeSort(1,N);
        // for(int i=1;i<=N;i++)
        //     System.out.print(tmpC[i]+" ");
        find(N,M);
    }
  }

  // merge sort
  public static void mergeSort(int start,int end){

    if(start==end)
      return ;

    // left
    mergeSort(start, start+(end-start)/2);
    // right
    mergeSort(start+(end-start)/2+1, end);

    merge(start, start+(end-start)/2 ,end );
  }// end method

  // 병합?
  public static void merge(int start, int mid, int end){

    int[] tmpArr=new int[end-start+1];//temp arr
    int idx=0;
    int left=start;// 왼쪽 시작점
    int right=mid+1;// 오른쪽 시작점

    while(left<=mid&&right<=end){
      if(c[left]<c[right]){
        tmpArr[idx++]=c[left];
        left++;
      }
      else{
        tmpArr[idx++]=c[right];
        right++;
      }
    }//
    // 왼쪽이 끝난경우, 오른쪽의 나머지를 복사한다.
    if(left>mid){
      while(right<=end){tmpArr[idx++]=c[right++];}
    }
    else{
      while(left<=mid){tmpArr[idx++]=c[left++];}
    }

    // 임시 배열의 원소를 본 배열에 덮어쓴다.
    for(int i=0;i<end-start+1;i++){
      c[start+i]=tmpArr[i];
    }
  }// end method

  public static void find(int N,int M){

    for(int me=1;me<=N;me++){
      int myCost=tmpC[me];
      int yourCostIdx= bSearch(tmpC, 1,N,M-myCost);

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
  public static int bSearch(int start, int end, int target){

    if(start==end)
      return -1;

    int mid= start+(end-start)/2;

    if(c[mid]<target)
      return bSearch(c,mid+1,end,target);
    else if(c[mid]==target)
      return mid;
    else
      return bSearch(c,start,mid-1,target);
  }


}
