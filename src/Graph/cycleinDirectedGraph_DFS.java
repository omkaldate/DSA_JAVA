package Graph;

import java.util.ArrayList;

public class cycleinDirectedGraph_DFS {

    public static boolean DFS(int node, int[]vis, int[]path, ArrayList<ArrayList<Integer>> list){
        vis[node] = 1;
        path[node] = 1;

        for(int x: list.get(node)){
            if(vis[x] == 0){
                if(DFS(x,vis,path,list) == true) return true;
            }
            else if(path[x] == 1) return true;
        }

        path[node] = 0;
        return false;
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[]vis = new int [V];
        int[]path = new int[V];

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(DFS(i,vis,path,adj) == true) return true;
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
        System.out.println(isCyclic(v,list));
    }
}
