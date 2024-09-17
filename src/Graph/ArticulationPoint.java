package Graph;

import java.util.ArrayList;

public class ArticulationPoint {

    public static int timer = 0;
    public static void DFS(int node, int parent, int[]vis, int[]tin, int[]low, int[]mark, ArrayList<ArrayList<Integer>> list){
        vis[node] =1;
        tin[node] = low[node] = timer++;
        int child =0;

        for(int it : list.get(node)){
            if(it == parent) continue;

            if(vis[it] ==0){
                DFS(it,node,vis,tin,low,mark,list);
                low[node] = Math.min(low[node] ,low[it]);

                if(tin[node] <= low[it] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node] , tin[it]);
            }

            if(child >1 && parent == -1) mark[node] =1;
        }
    }


    public static ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj){
        int[]vis = new int[V];
        int[]tin = new int[V];
        int[]low = new int[V];
        int[]mark = new int[V];

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                DFS(i,-1,vis,tin,low,mark,adj);
            }
        }


        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(mark[i] == 1) ans.add(i);
        }

        if(ans.size() ==0) ans.add(-1);
        return ans;
    }


    public static void main(String[] args) {

    }
}
