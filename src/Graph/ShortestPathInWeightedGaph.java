package Graph;

import java.util.*;

class ShortestPathInWeightedGaph {

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static List<Integer> shortestPath(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(dist, (int) 1e9);
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new Pair(0, 1));


        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.second;
            int dis = it.first;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edgeWeight = iter.second;

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[n] == (int) 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
            {1, 2, 2},
            {1, 3, 4},
            {2, 3, 1},
            {2, 4, 7},
            {3, 5, 3},
            {4, 5, 1}
        };

        List<Integer> shortestPath = shortestPath(n, edges);
        System.out.println("Shortest path: " + shortestPath);
    }
}
