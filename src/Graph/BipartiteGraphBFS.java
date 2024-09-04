package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {

    public static boolean check(int start , int v, int[]vis , ArrayList<ArrayList<Integer>>list){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = 0;

        while(! q.isEmpty()){
            int node = q.poll();

            for(int adj : list.get(node)){
                if(vis[adj] == -1){
                    vis[adj] = 1 - vis[node];
                    q.offer(adj);
                }
                else if(vis[adj] == vis[node]){
                    return false;
                }
            }
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

        for(int v=0; v<n; v++){
            if(vis[v] == -1){
                if(check(v,n,vis,list) == false) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][]arr = {
                {1,2,3},
                {0,3},
                {0,1,2},
                {0,2}
        };
        System.out.println(isBipartite(arr));
    }
}
