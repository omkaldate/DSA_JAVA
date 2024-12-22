package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindBuildingWhereAliceandBobCanMeet {
    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer,-1);
        List<int[]>[] tempQueries = new List[heights.length];

        for(int i=0;i<heights.length;i++){
            tempQueries[i]=new ArrayList<>();
        }

        for(int i=0;i<queries.length;i++){
            int a = queries[i][0];
            int b = queries[i][1];
            if(a>b){
                int temp = a;
                a=b;
                b=temp;
            }
            if((a<b && heights[a]<heights[b]) || a==b) answer[i]=b;
            else tempQueries[b].add(new int[]{heights[a],i});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0]-b[0]);
        for(int i=0;i<heights.length;i++){
            while(!pq.isEmpty() && pq.peek()[0]<heights[i]){
                answer[pq.remove()[1]]=i;
            }
            for(int[] tempQuery : tempQueries[i]){
                pq.add(tempQuery);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        
    }
}