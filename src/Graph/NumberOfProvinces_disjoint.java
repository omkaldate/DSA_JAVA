package Graph;

import java.util.ArrayList;

public class NumberOfProvinces_disjoint {

    static class disjoint{
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();

        disjoint(int v){
            for(int i=0; i<v; i++){
                parent.add(i);
                size.add(1);
            }
         //   System.out.println(parent);
         //   System.out.println(size);
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

    public static int previnces(ArrayList<ArrayList<Integer>> list , int v){
        disjoint ds = new disjoint(v);
        int ans =0;

        for(int i=0; i<v; i++){
            for(int y : list.get(i)){
                ds.unionBySize(i,y);
            }
        }


        for(int i=0; i<v; i++){
            if(ds.parent.get(i) == i) ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][]matrix = {
                {0,1,0,0,0,0,0},
                {1,0,1,0,0,0,0},
                {0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,1,0}
        };

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j] == 1){
                    list.get(i).add(j);
                }
            }
        }

        //for(ArrayList<Integer> x : list){
         //   System.out.println(x);
       // }

        System.out.println(previnces(list, matrix.length));
    }
}
