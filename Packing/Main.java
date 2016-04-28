import java.util.*;

public class Main{

  public static String[] names=null;
  public static int[] volumes=null;
  public static int[] wanteds=null;
  public static boolean[] taken=null;
  public static boolean[] selected=null;

  public static int W=0;
  public static int N=0;
  public static int maxWanted = 0;

  public static void main(String[] params){

    Scanner s = new Scanner(System.in);

    int C=s.nextInt();

    for(int c=0;c<C;c++){
      N=s.nextInt();
      W=s.nextInt();

      //초기화
      names=new String[N];
      volumes=new int[N];
      wanteds=new int[N];
      taken=new boolean[N];
      selected= new boolean[N];

      s.nextLine();

      for(int n=0;n<N;n++){
        String[] input=null;
        input = s.nextLine().split(" ");
        names[n]=input[0];
        volumes[n]=Integer.parseInt(input[1]);
        wanteds[n]=Integer.parseInt(input[2]);
      }
      
      pack(0,0,0);
      printResult();
    }
  }// end method
  public static void pack(int start, int crrV, int crrW){

    if(crrV>W)
      return;
    if(maxWanted<crrW){
      maxWanted = crrW;
      selected = (boolean[])taken.clone();
      /*
      for(int i=0;i<N;i++){
        if(taken[i])
          selected[i]=true;
        else
          selected[i]=false;
      }
      */
      return;
    }
    /*
    for(int idx=start;idx<N;idx++){
        taken[idx]=true;
        pack(idx+1, crrV+volumes[idx], crrW+wanteds[idx]);
        taken[idx]=false;
    }// end for
    */

    for(int idx=0;idx<N;idx++){
      if(!taken[idx]){
        taken[idx]=true;
        pack(idx+1, crrV+volumes[idx], crrW+wanteds[idx]);
        taken[idx]=false;
      }
    }// end for

  }// end method

  public static void printResult(){
    int cnt=0;

    //가져 갈 물건의 수 계산
    for(boolean item:selected){
      if(item)
        cnt++;
    }
    System.out.println(maxWanted+" "+cnt);
    // 가져 갈 물건의 이름 출력
    for(int idx=0;idx<N;idx++){
      if(selected[idx]){
        System.out.println(names[idx]);
      }
    }
  }// end method
}
