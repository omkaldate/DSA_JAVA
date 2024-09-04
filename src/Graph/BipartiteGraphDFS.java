package Graph;

import java.util.ArrayList;

public class BipartiteGraphDFS {

    public static boolean checkDFS(int node, int col, int[]vis , ArrayList<ArrayList<Integer>> list){
        vis[node] = col;

        for(int i : list.get(node)){
            if(vis[i] == -1){
                if(checkDFS(i,1-col,vis,list) == false) return false;
            }
            else if(vis[i] == col) return false;
        }
        return true;
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());

        for(int a=0; a<n; a++){
            for(int b=0; b<graph[a].length; b++){
                list.get(a).add(graph[a][b]);
            }
        }

        int[] vis = new int[n];
        for(int x =0; x<n; x++) vis[x]=-1;

        for(int i=0; i<n; i++){
            if(vis[i] == -1){
                if(! checkDFS(i,0,vis,list)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {0, 3},
                {0, 1, 2},
                {0, 2}
        };
        System.out.println(isBipartite(arr));
    }
}
