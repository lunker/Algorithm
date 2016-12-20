import java.io.*;
import java.util.*;

class Track{
    
    public long start;
    public long end;

    public Track(long s, long e){
        start = s;
        end = e;
    }    
}


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        int START = 0;
        int END = 1; 
        
        long n=0;
        long m=0;
        int k=0;
        long r=0; // start : 1 
        long c1=0;
        long c2=0;
    
        // 배열 대신 adjacency list로 구현하기 
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        
        
        // int[][] track = new int[n+1][2];

        Map<Long, Track> trackList = new HashMap<Long, Track>();

        for(int idx=0; idx<k; idx++){
            r = scanner.nextInt();
            c1 = scanner.nextInt();
            c2 = scanner.nextInt();
            

            if(trackList.containsKey(r)){
                Track tmp = trackList.get(r);

                if(tmp.start > c1){
                    tmp.start = c1;
                }
                if(tmp.end < c2){
                    tmp.end = c2;
                }
                trackList.put(r,tmp);
            }
            else{
                trackList.put(r, new Track(c1,c2));
            }
        }// end for 
        
        long trackSum = 0;
        // calculate 
        Iterator<Track> trackItr = trackList.values().iterator();

        while(trackItr.hasNext()){

            Track tmp = trackItr.next();

            trackSum += tmp.end - tmp.start + 1; 
        }
        long tmp = n * m; 

        System.out.println(tmp - trackSum);
    }
}