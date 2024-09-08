package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestpathDirictedGraphTopo {
    static class pair{
        int first,second;
        pair(int a , int b){
            this.first = a;
            this.second = b;
        }
    }

    public static void topo(int node, ArrayList<ArrayList<pair>> list, int[] vis, Stack<Integer> stk) {
        vis[node] = 1;
        for (int i = 0; i < list.get(node).size(); i++) {
            int v = list.get(node).get(i).first;
            if (vis[v] == 0) {
                topo(v, list, vis, stk);
            }
        }
        stk.push(node);
    }


    public static int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0; i<N; i++) adj.add(new ArrayList<pair>());

        for(int j=0; j<M; j++){
            int x = edges[j][0];
            int y = edges[j][1];
            int z = edges[j][2];

            adj.get(x).add(new pair(y,z));
        }

        int[]vis = new int[N];
        Stack<Integer> stk = new Stack<>();
        for(int k =0; k<N; k++){
            if(vis[k] == 0) topo(k,adj,vis,stk);
        }

        int[]dis = new int[N];
        Arrays.fill(dis,(int)(1e9));
        dis[0] = 0;

        while(! stk.isEmpty()){
            int node = stk.pop();

            for(int q=0; q<adj.get(node).size(); q++){
                int v = adj.get(node).get(q).first;
                int wt = adj.get(node).get(q).second;

                if(dis[node] + wt < dis[v]){
                    dis[v] = wt+dis[node];
                }
            }
        }
        for(int s=0; s<N; s++){
            if(dis[s] == 1e9) dis[s] = -1;
        }
        return dis;
    }


    public static void main(String[] args) {
        int[][]edge={
                {0,1,2},
                {0,2,1}
               };
        System.out.println(Arrays.toString(shortestPath(4,2,edge)));
    }
}
