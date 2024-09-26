package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class RemovemaxNumberOfEdgesToKeepGraphFullyTraversable {
    static class DSU{
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
        int components;

        DSU(int n){
            components = n;
            for(int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node){
            if(node == parent.get(node)) return node;

            int save = findParent(parent.get(node));
            parent.set(node,save);
            return save;
        }

        public void union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(size.get(pu) < size.get(pv)){
                parent.set(pu,pv);
                size.set(pv, size.get(pu)+size.get(pv));
            }
            else{
                parent.set(pv,pu);
                size.set(pu, size.get(pu)+size.get(pv));
            }
            components--;
        }

        public boolean isSingleCompo(){
            return components ==1;
        }
    }


    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU Alice = new DSU(n);
        DSU Bob = new DSU(n);

        Arrays.sort(edges, (a, b) -> Integer.compare(b[0] , a[0]));

        int edgeCount =0;

        for(int[]arr : edges){
            int type = arr[0];
            int u = arr[1]-1;
            int v = arr[2]-1;   //given1 base indexing but we wrote clas for 0 base

            if(type == 3){
                boolean edgeUsed = false;
                if(Alice.findParent(u) != Alice.findParent(v)){   // Alice
                    Alice.union(u,v);
                    edgeUsed = true;
                }

                if(Bob.findParent(u) != Bob.findParent(v)){   // Bob
                    Bob.union(u,v);
                    edgeUsed = true;
                }
                if(edgeUsed == true) edgeCount++;
            }
            if(type == 2){
                if(Bob.findParent(u) != Bob.findParent(v)){   // Bob
                    Bob.union(u,v);
                    edgeCount++;
                }
            }
            if(type == 1){
                if(Alice.findParent(u) != Alice.findParent(v)){   // Alice
                    Alice.union(u,v);
                    edgeCount++;
                }
            }

        }
        if(Alice.isSingleCompo() == true && Bob.isSingleCompo() == true){
            return edges.length - edgeCount;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] edges = {
                {3,1,2},
                {3,2,3},
                {1,1,3},
                {1,2,4},
                {1,1,2},
                {2,3,4}
        };
        System.out.println(maxNumEdgesToRemove(4,edges));
    }
}
