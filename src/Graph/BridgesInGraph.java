package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {
    private static int timer =1;
    public static void DFS(int node, int parent, int[]vis, List<List<Integer>> list, int[]tin, int[]low, List<List<Integer>> ans){
        vis[node] = 1;
        tin[node] = low[node] = timer++;

        for(int it: list.get(node)){
            if(it == parent) continue;

            if(vis[it] == 0){
                DFS(it,node,vis,list,tin,low,ans);
                low[node] = Math.min(low[node],low[it]);

                if(low[it] > tin[node]){
                    ans.add(Arrays.asList(node,it) );
                }
            }
            else{
                low[node] = Math.min(low[node] , low[it]);
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(List<Integer> x: connections){
            int u = x.get(0);
            int v = x.get(1);

            list.get(u).add(v);
            list.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> ans = new ArrayList<>();
        DFS(0,-1,vis,list,tin,low,ans);

        return ans;
    }

    public static void main(String[] args) {

    }
}
