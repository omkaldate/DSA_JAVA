package Graph;

import java.util.ArrayList;

public class NumberOfOperationsTomakeGraphConnected {

   static class disjoint{
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();

        disjoint(int v){
            for(int i=0; i<v; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node){
            if(parent.get(node) == node) return node;

            int save = findParent(parent.get(node));
            parent.set(node, save);
            return save;
        }

        public void unionBySize(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return;

            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }



    public static int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        disjoint ds = new disjoint(n);
        int cntExtra =0;

        for(int i=0; i<m; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findParent(u) == ds.findParent(v)){
                cntExtra++;
            }
            else{
                ds.unionBySize(u,v);
            }
        }

        int cntC =0;
        for(int i=0; i<n; i++){
            if(ds.parent.get(i) == i) cntC++;
        }

        int ans = cntC-1;
        if(ans <= cntExtra) return ans;
        return -1;
    }


    public static void main(String[] args) {
        int[][]arr = {
                {0,1},{0,2},{0,3},{1,2},{1,3}
        };

        System.out.println(makeConnected(6, arr));
    }

}
