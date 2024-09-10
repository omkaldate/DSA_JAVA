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

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to adjacency list
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2])); // from -> to, weight
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2])); // to -> from, weight (undirected graph)
        }

        // Priority queue for Dijkstra's algorithm, sorted by distance (min-heap)
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        // Initialize distances and parent arrays
        Arrays.fill(dist, (int) 1e9);  // A large number as infinity
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        dist[1] = 0;  // Start node has a distance of 0
        pq.add(new Pair(0, 1));  // Add the starting node to the priority queue

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.second;
            int dis = it.first;

            // Traverse the adjacent nodes
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edgeWeight = iter.second;

                // If a shorter path is found
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        // Construct the shortest path from source (1) to destination (n)
        List<Integer> path = new ArrayList<>();
        if (dist[n] == (int) 1e9) {  // If no path exists
            path.add(-1);
            return path;
        }

        int node = n;
        // Traverse backwards from destination to source using the parent array
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);  // Add the source node

        // Reverse the path to get it from source to destination
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
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
