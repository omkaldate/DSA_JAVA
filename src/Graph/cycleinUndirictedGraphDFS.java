package Graph;

import java.util.ArrayList;

public class cycleinUndirictedGraphDFS {

    public static boolean BFS(ArrayList<ArrayList<Integer>> list, int[] vis, int node,int parent) {
        vis[node] = 1;
        for (int adjNode : list.get(node)) {
            if (vis[adjNode] == 0) {
                if(BFS(list,vis,adjNode,node) == true) return true;
            } else if (parent != adjNode) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] edge = {
                {0,0,0,0},
                {0,0,1,1},
                {0,1,0,1},
                {0,1,1,0}
        };

        int v = edge.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= v; i++) list.add(new ArrayList<>());


        for (int a=0; a<v; a++){
          for(int b=0; b<v; b++){
              if(edge[a][b] == 1) list.get(a).add(b);
          }
        }

        int[]vis = new int[v];
        for(int i=0; i<v; i++) {
            if(vis[i] == 0) {
                if(BFS(list, vis, i, -1) == true) System.out.println("cycle is detected");
            }
        }
    }
}
