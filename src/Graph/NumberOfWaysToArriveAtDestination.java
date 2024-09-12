package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    static class Pair{
        long first;
        long second;
        Pair(long a , long b){
            this.first = a;
            this.second = b;
        }
    }

    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] x : roads) {
            list.get(x[0]).add(new Pair(x[1], x[2]));
            list.get(x[1]).add(new Pair(x[0], x[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));
        int mod = (int) 1e9 + 7;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            long node = p.second;
            long d = p.first;

            for (Pair adj : list.get((int) node)) {
                long adjNode = adj.first;
                long adjWeight = adj.second;

                if (d + adjWeight < dist[(int) adjNode]) {
                    dist[(int) adjNode] = d + adjWeight;
                    pq.offer(new Pair(dist[(int) adjNode], adjNode));
                    ways[(int) adjNode] = ways[(int) node];
                } else if (d + adjWeight == dist[(int) adjNode]) {
                    ways[(int) adjNode] = (ways[(int) adjNode] + ways[(int) node]) % mod;
                }
            }
        }
        return (int) ways[n - 1];
    }


    public static void main(String[] args) {
        int[][]arr = {
                {0,6,7},
                {0,1,2},
                {1,2,3},
                {1,3,3},
                {6,3,3},
                {3,5,1},
                {6,5,1},
                {2,5,1},
                {0,4,5},
                {4,6,2}
        };

        System.out.println(countPaths(7,arr));
    }
}
