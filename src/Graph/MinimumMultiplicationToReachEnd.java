package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd {
    static class Pair{
        int node;
        int step;
        Pair(int a , int b){
            this.node = a;
            this.step = b;
        }
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, 0));

        int[] dist = new int[100000];
        Arrays.fill(dist,(int) 1e9);
        dist[start] = 0;

        int mod = 100000;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int steps = p.step;

            for (int it : arr) {
                int num = (it * node) % mod;

                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;

                    if (num == end)
                        return steps + 1;

                    q.offer(new Pair(num, steps + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {2,5,7};
        System.out.println(minimumMultiplications(arr,3,75));
    }
}
