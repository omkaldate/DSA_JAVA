package Graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates_DFS {
    public static boolean DFS(int node, int[]vis, int[]path, int[]check, List<List<Integer>> list){
        vis[node] = 1;
        path[node] = 1;
        check[node] = 0;

        for(int i : list.get(node)){
            if(vis[i] == 0){
                if(DFS(i,vis,path,check,list) == true) return true;
            }
            else if(path[i] == 1) return true;
        }
        path[node] = 0;
        check[node] = 1;
        return false;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph){

        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());

        for(int a=0; a<n; a++){
            for(int b=0; b<graph[a].length; b++){
                list.get(a).add(graph[a][b]);
            }
        }

        int[] vis = new int[n];
        int[] path = new int[n];
        int[] check = new int[n];

        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                DFS(i,vis,path,check,list);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int j =0; j<n; j++){
            if(check[j] == 1) ans.add(j);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        System.out.println(eventualSafeNodes(arr));
    }
}
