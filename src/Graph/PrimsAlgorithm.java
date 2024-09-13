package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Pair {
        int dis;
        int node;
        Pair(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }
    }

    // Method to find the minimum spanning tree
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dis - y.dis);
        int[] vis = new int[V];
        pq.offer(new Pair(0, 0)); // Start from node 0
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int dis = p.dis;
            int node = p.node;

            if (vis[node] == 1) continue; // If already visited, skip
            vis[node] = 1;
            sum += dis;

            // Iterate over the adjacent nodes of the current node
            for (int[] list : adj.get(node)) {
                int n = list[0]; // The adjacent node
                int adgeW = list[1]; // The weight of the edge

                if (vis[n] == 0) {
                    pq.offer(new Pair(adgeW, n));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 6;


        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        adj.get(0).add(new int[]{1, 2});
        adj.get(1).add(new int[]{0, 2});

        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});

        adj.get(0).add(new int[]{3, 6});
        adj.get(3).add(new int[]{0, 6});

        adj.get(1).add(new int[]{3, 8});
        adj.get(3).add(new int[]{1, 8});

        adj.get(1).add(new int[]{4, 5});
        adj.get(4).add(new int[]{1, 5});

        adj.get(2).add(new int[]{4, 7});
        adj.get(4).add(new int[]{2, 7});

        int mstCost = spanningTree(V, E, adj);
        System.out.println("The cost of the minimum spanning tree is: " + mstCost);
    }
}
