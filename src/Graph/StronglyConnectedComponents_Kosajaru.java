package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StronglyConnectedComponents_Kosajaru {
    public static void DFS(int node,int[]vis , Stack<Integer> stk , ArrayList<ArrayList<Integer>> list){
        vis[node] =1;
        for(int adj : list.get(node)){
            if(vis[adj] == 1) continue;
            DFS(adj,vis,stk,list);
        }
        stk.push(node);
    }


    public static void DFS2(int node, int[]vis, ArrayList<ArrayList<Integer>> list){
        vis[node] = 1;
        for(int it : list.get(node)){
            if(vis[it] == 1) continue;
            DFS2(it,vis,list);
        }
    }



    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        int[]vis = new int[V];
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<V; i++){
            if(vis[i] ==0 ){
                DFS(i,vis,stk,adj);
            }
        }

        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for(int k=0; k<adj.size(); k++) adj2.add(new ArrayList<>());

        for(int i=0; i<adj.size(); i++){
            for(int it : adj.get(i)){
                adj2.get(it).add(i);
            }
        }

        Arrays.fill(vis,0);
        int ans =0;
        for(int i=0; i<V; i++){
            int node = stk.pop();
            if(vis[node] == 1) continue;
            ans++;
            DFS2(node,vis,adj2);
        }
        return ans;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Example graph with 5 vertices
        list.add(new ArrayList<>(Arrays.asList(2, 3))); // Edges from vertex 0 to 2, 3
        list.add(new ArrayList<>(Arrays.asList(0)));    // Edge from vertex 1 to 0
        list.add(new ArrayList<>(Arrays.asList(1)));    // Edge from vertex 2 to 1
        list.add(new ArrayList<>(Arrays.asList(4)));    // Edge from vertex 3 to 4
        list.add(new ArrayList<>(Arrays.asList()));     // No outgoing edge from vertex 4

        int V = 5; // Number of vertices
        System.out.println("Number of strongly connected components: " + kosaraju(V, list));
    }
}
