package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalsAlgorithm {

    static class Disjoint_UnionRank {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        Disjoint_UnionRank(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node)) return node;
            int save = findParent(parent.get(node));
            parent.set(node, save);
            return save;
        }

        public void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv) return;

            if (rank.get(pu) < rank.get(pv)) {
                parent.set(pu, pv);
            } else if (rank.get(pu) > rank.get(pv)) {
                parent.set(pv, pu);
            } else {
                parent.set(pv, pu);
                rank.set(pu, rank.get(pu) + 1);
            }
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();

        // Collect edges from adjacency list
        for (int i = 0; i < V; i++) {
            for (int[] edge : adj.get(i)) {
                int adjNode = edge[0];
                int wt = edge[1];
                Edge temp = new Edge(i, adjNode, wt);
                edges.add(temp);
            }
        }

        // Initialize Disjoint Set
        Disjoint_UnionRank ds = new Disjoint_UnionRank(V);

        // Sort edges by weight
        Collections.sort(edges);

        int mstWt = 0;

        // Apply Kruskal's algorithm
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int wt = edge.weight;

            if (ds.findParent(u) != ds.findParent(v)) {
                mstWt += wt;
                ds.union(u, v);
            }
        }

        return mstWt;
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges

        // Initialize adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (src, dest, weight)
        adj.get(0).add(new int[]{1, 10});
        adj.get(1).add(new int[]{0, 10});
        adj.get(0).add(new int[]{2, 6});
        adj.get(2).add(new int[]{0, 6});
        adj.get(0).add(new int[]{3, 5});
        adj.get(3).add(new int[]{0, 5});
        adj.get(1).add(new int[]{3, 15});
        adj.get(3).add(new int[]{1, 15});
        adj.get(2).add(new int[]{3, 4});
        adj.get(3).add(new int[]{2, 4});

        // Calculate and print MST weight
        int mstWeight = spanningTree(V, E, adj);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }
}
