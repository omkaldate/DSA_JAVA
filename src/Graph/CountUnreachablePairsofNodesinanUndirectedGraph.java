package Graph;

import java.util.ArrayList;

public class CountUnreachablePairsofNodesinanUndirectedGraph {

    static class disjointSet{
        int n;
        int[]size;
        int[]parent;

        disjointSet(int a){
            n = a;
            size = new int[n];
            parent = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        public void union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu == pv) return;

            if(size[pu] < size[pv]){
                size[pv] += size[pu];
                parent[pu] = pv;
            }
            else{
                size[pu] += size[pv];
                parent[pv] = pu;
            }
        }



    }

    public static long countPairs(int n, int[][] edges) {
        disjointSet disj = new disjointSet(n);

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            int pa = disj.findParent(a);
            int pb = disj.findParent(b);
            if(pa != pb){
                disj.union(a,b);
            }
        }

        ArrayList<Integer> compo = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(disj.parent[i] == i){
                compo.add(disj.size[i]);
            }
        }

        long ans = 0;
        int len = n;
        for(int i=0; i<compo.size(); i++){
            ans +=(long) (len-compo.get(i)) * compo.get(i);

            len -= compo.get(i);
        }

        return ans;
    }


    public static void main(String[] args) {
            int n = 7;
            int[][]edges = {
                    {0,2},
                    {0,5},
                    {2,4},
                    {1,6},
                    {5,4}
            };

            long ans = countPairs(n, edges);
             System.out.println(ans);
    }
}
