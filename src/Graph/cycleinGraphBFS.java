package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cycleinGraphBFS {

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean checkCycle(ArrayList<ArrayList<Integer>> list, int[] vis, int i) {
        vis[i] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, -1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int parent = p.parent;

            for (int adjNode : list.get(node)) {
                if (vis[adjNode] == 0) {
                    vis[adjNode] = 1;
                    q.offer(new Pair(adjNode, node));
                } else if (parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[v + 1];

        for (int x = 1; x <= v; x++) {
            if (vis[x] == 0) {
                if (checkCycle(adj, vis, x)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edge = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        };

        int v = 5; // The number of vertices in the graph
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        // Construct the adjacency list
        for (int[] e : edge) {
            int u = e[0];
            int v2 = e[1];
            list.get(u).add(v2);
            list.get(v2).add(u);
        }

        System.out.println(isCycle(v, list));
    }
}
