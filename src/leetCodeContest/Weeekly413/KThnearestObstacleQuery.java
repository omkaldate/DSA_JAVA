package leetCodeContest.Weeekly413;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KThnearestObstacleQuery {
    public static int[] resultsArray(int[][] queries, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] results = new int[queries.length];

        for (int i=0; i<queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            int distance = Math.abs(x) + Math.abs(y);
            pq.offer(distance);

            if (pq.size() > k) pq.poll();
            if (pq.size() < k) results[i] = -1;
            else results[i] = pq.peek();
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] query = {{1,2},{3,4},{2,3},{-3,0}};
        System.out.println(Arrays.toString(resultsArray(query,2)));
    }
}
