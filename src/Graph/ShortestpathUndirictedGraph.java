package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestpathUndirictedGraph {
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());

        for (int j = 0; j < m; j++) {
            list.get(edges[j][0]).add(edges[j][1]);
            list.get(edges[j][1]).add(edges[j][0]);
        }

        int[]dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] =0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(! q.isEmpty()){
            int node = q.poll();
            for(int i : list.get(node)){
                if(dis[node]+1 < dis[i]){
                    dis[i] = dis[node]+1;
                    q.offer(i);
                }
            }
        }

        for(int i=0; i<n; i++){
            if(dis[i] == Integer.MAX_VALUE) dis[i] = -1;
        }

        return dis;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {1,3},
                {3,0}
        };
        System.out.println(Arrays.toString(shortestPath(arr,4,2,3)));
    }
}
