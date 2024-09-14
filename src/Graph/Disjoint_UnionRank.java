package Graph;

import java.util.ArrayList;
import java.util.List;

public class Disjoint_UnionRank {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    Disjoint_UnionRank(int n){
        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)) return node;

        int save = findParent(parent.get(node));
        parent.set(node, save);
        return save;
    }

    public void union(int u , int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv) return;
        if(rank.get(pu) < rank.get(pv)){
            parent.set(pu, pv);
        }
        else if(rank.get(pu) > rank.get(pv)){
            parent.set(pv, pu);
        }
        else{
            parent.set(pv,pu);
            int rank_u = rank.get(pu);
            rank.set(pu,rank_u+1);
        }
    }


    public static void main(String[] args) {
        Disjoint_UnionRank ds = new Disjoint_UnionRank(7);


        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("3 and 7 are in the same set");
        } else {
            System.out.println("3 and 7 are in different sets");
        }

        ds.union(3, 7);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("3 and 7 are now in the same set");
        } else {
            System.out.println("3 and 7 are still in different sets");
        }
    }
}
