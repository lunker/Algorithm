import java.util.*;

public class MergeSort{

  public static int[] input={5,8,1,2,4,6,9};

  public static void main(String[] params){

    sort(0,input.length-1);


  }

  public static void sort(int start, int end){
    if(start==end)
      return;

    int mid=start+(end-start)/2;
    sort(start,mid);
    sort(mid+1,end);

    merge(start, mid, end );
  }

  public static void merge(int start, int mid, int end){

      int[] tmpArr=new int[end-start+1];
      int index=0;
      int left=start;
      int right=mid+1;

      while(left<=mid&&right<=end){

        if(input[left]<input[right]){
          tmpArr[index++]=input[left];
          left++;
        }
        else if(input[left]>input[right]){
          tmpArr[index++]=input[right];
          right++;
        }
        else{
          tmpArr[index++]=input[right];
          right++;
        }
      }

      if()

      for(int i:input)
        System.out.print(i+" ");
      System.out.println();

  }

}
