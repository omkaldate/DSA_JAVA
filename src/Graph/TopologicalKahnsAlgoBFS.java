package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalKahnsAlgoBFS {

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int indegree[] = new int[V];
    for(int i=0; i<V; i++){
        for(int x : adj.get(i)){
            indegree[x]++;
        }
    }

    Queue<Integer>q = new LinkedList<>();
    for(int j=0; j<V; j++){
        if(indegree[j] == 0){
            q.add(j);
        }
    }

    int[] topo = new int[V];
    int k =0;

    while(! q.isEmpty()){
        int node = q.poll();
        topo[k++] = node;

        for(int it : adj.get(node)){
            indegree[it]--;
            if(indegree[it] == 0) q.add(it);
        }
    }
    return topo;
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
