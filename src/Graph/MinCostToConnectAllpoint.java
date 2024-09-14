package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllpoint {
    static class Pair {
        int node;
        int dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int minCostConnectPoints(int[][] points) {
        int V = points.length;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new Pair(j, d));
                adj.get(j).add(new Pair(i, d));
            }
        }
        return primsAlgo(adj, V);
    }

    public static int primsAlgo(List<List<Pair>> adj, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);

        boolean[] visited = new boolean[V];
        int cnt = 0;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.dist;

            if (visited[node]) continue;
            visited[node] = true;
            cnt += dis;

            for (Pair neighbor : adj.get(node)) {
                if (!visited[neighbor.node]) {
                    pq.offer(neighbor);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {0,0},
                {2,2},
                {3,10},
                {5,2},
                {7,0}
        };
        System.out.println(minCostConnectPoints(arr));
    }

}
