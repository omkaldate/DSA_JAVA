package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort_DFS {

    public static void DFS(int node , int[]vis , ArrayList<ArrayList<Integer>> list , Stack<Integer> stk){
        vis[node] = 1;

        for(int i : list.get(node)){
            if(vis[i] == 0){
                DFS(i,vis,list,stk);
            }
        }
        stk.push(node);
    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> stk = new Stack<>();
        int[]vis = new int[V];

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                DFS(i,vis,adj,stk);
            }
        }

        int[]ans = new int[V];
        int x=0;
        while(! stk.isEmpty()){
            ans[x++] = stk.pop();
        }

        return ans;
    }


    public static void main(String[] args) {

        int[][] graph = {
                {},
                {},
                {3},
                {1},
                {0,1},
                {0,2}
        };



        int n = graph.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());

        for(int a=0; a<n; a++){
            for(int b=0; b<graph[a].length; b++){
                list.get(a).add(graph[a][b]);
            }
        }

        System.out.println(Arrays.toString(topoSort(n,list)));
    }
}
