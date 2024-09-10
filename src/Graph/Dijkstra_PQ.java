package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_PQ {

    static class pair {
        int dist;
        int node;
        pair(int a, int b) {
            this.dist = a;
            this.node = b;
        }
    }

    static class store {
        int node;
        int weight;
        store(int b, int a) {  // Corrected constructor: node first, weight second
            this.node = b;     // destination node
            this.weight = a;    // edge weight
        }
    }

    public static int[] dij(int v, ArrayList<ArrayList<store>> adj, int s) {
        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int[] distance = new int[v];
        Arrays.fill(distance, (int) 1e9);
        distance[s] = 0;

        pq.offer(new pair(0, s));

        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int d = p.dist;
            int node = p.node;

            for (store neighbor : adj.get(node)) {
                int edgeweight = neighbor.weight;  // Correct usage of weight
                int adjnode = neighbor.node;

                if (d + edgeweight < distance[adjnode]) {
                    distance[adjnode] = d + edgeweight;
                    pq.offer(new pair(distance[adjnode], adjnode));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int v = 5; // number of vertices
        ArrayList<ArrayList<store>> adj = new ArrayList<>();

        // Initializing the adjacency list
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges (u, v, weight) to the adjacency list
        adj.get(0).add(new store(1, 2)); // edge from 0 to 1 with weight 2
        adj.get(0).add(new store(2, 4)); // edge from 0 to 2 with weight 4
        adj.get(1).add(new store(2, 1)); // edge from 1 to 2 with weight 1
        adj.get(1).add(new store(3, 7)); // edge from 1 to 3 with weight 7
        adj.get(2).add(new store(3, 3)); // edge from 2 to 3 with weight 3
        adj.get(3).add(new store(4, 1)); // edge from 3 to 4 with weight 1

        int source = 0; // start node
        int[] distances = dij(v, adj, source);

        // Printing the shortest distances from source
        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < v; i++) {
            System.out.println("Node " + i + " -> " + distances[i]);
        }
    }
}
