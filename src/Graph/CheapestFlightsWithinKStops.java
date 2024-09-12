package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    static class Tuple{
        int f;
        int s;
        int t;
        Tuple(int a , int b, int c){
            this.f = a;
            this.s = b;
            this.t =c;
        }
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int v = flights.length;
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for(int x=0; x<n; x++) list.add(new ArrayList<>());

        for(int j =0; j<v; j++){
            list.get(flights[j][0]).add(new Pair(flights[j][1],flights[j][2]));
        }

        int[]dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));

        while(! q.isEmpty()){
            Tuple t = q.poll();
            int step = t.f;
            int node = t.s;
            int wei = t.t;

            if(step > k) continue;

            for(Pair p : list.get(node)){
                int pn = p.node;
                int pw = p.weight;

                if(wei + pw < dis[pn] && step <=k){
                    dis[pn] = wei+pw;
                    q.offer(new Tuple(step+1 , pn, wei+pw));
                }
            }
        }

        if(dis[dst] == 1e9) return -1;
        return dis[dst];
    }

    public static void main(String[] args) {
        int[][]arr = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        System.out.println(findCheapestPrice(4,arr,0,3,1));
    }
}
