package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Disjkstra_PQ {
    static class pair{
            int dist;
            int node;
            pair(int a , int b){
                this.dist = a;
                this.node = b;
            }
    }

    public static int[] dij(int v ,ArrayList<ArrayList<Integer>> adj , int s){
        PriorityQueue<pair>pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        int[]distance = new int[v];
        Arrays.fill(distance , (int)1e9);
        distance[s] = 0;

        pq.offer(new pair(0,s));

        while(! pq.isEmpty()){
            pair p = pq.poll();
            int d = p.dist;
            int node = p.node;

            for(int i=0; i<adj.get(node).size(); i++){
                int edgeweight = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);

                if(d+edgeweight < distance[adjnode]){
                    distance[adjnode] = d+edgeweight;
                    pq.offer(new pair(distance[adjnode] , adjnode));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
