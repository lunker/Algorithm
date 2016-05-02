import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public static int[][] G=null;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner s=new Scanner(System.in);
        int N=s.nextInt();// number of node
        int M=s.nextInt();// number of edge

        G=new int[N+1][N+1];
        for(int r=1;r<=N;r++){
            for(int c=1;c<=N;c++){
                G[r][c]=-1;
                G[c][r]=-1;
            }
        }

        for(int m=0;m<M;m++){
            int row=0;
            int col=0;
            int w=0;

            row=s.nextInt();
            col=s.nextInt();
            w=s.nextInt();

            if(G[row][col]==-1){
                G[row][col]=w;
                G[col][row]=w;
            }
            else if(G[row][col]>w){
                G[row][col]=w;
                G[col][row]=w;
            }
        }
        int S=s.nextInt();
        System.out.println(prims(N,M,S));
    }// end method

    public static int prims(int N, int M, int START){
        int ret=0;
        int[] minWeight=null; // 현재까지 만들어진 tree에서 각 정점까지의 거리
        boolean[] added=null;


        minWeight=new int[N+1];
        for(int i=1;i<=N;i++)
            minWeight[i]=Integer.MAX_VALUE;
        added=new boolean[N+1];

        //added[START]=true;
        minWeight[START]=0;
        for(int i=1;i<=N;i++){
            // 아직 추가하지 않은 정점 중, 가장 가까운 정점 find
            int min=Integer.MAX_VALUE;
            int minIdx=-1;
            for(int node=1;node<=N;node++){
                if(!added[node] && minWeight[node]<min){
                    minIdx=node;
                    min=minWeight[node];
                }
            }

            if(minIdx!=-1){
                // 해당 정점을 결과에 추가
                added[minIdx]=true;
                ret+=minWeight[minIdx];

                // 해당 정점의 인접 정점들에 대해서 minWeight[] 갱신
                for(int there=1;there<=N;there++){
                    if(G[minIdx][there]>=0 && minWeight[there]>G[minIdx][there]){
                        minWeight[there]=G[minIdx][there];
                    }
                }
            }// end if
        }// end for
        return ret;
    }// end method
}
