package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MaximumConnectedGroup {

   static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        public DisjointSet(int n) {
            for (int i = 0; i <n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
   }
        public static int formula(int i , int j , int n){
            return (i*n)+j;
        }

        public static int largestIsland(int[][] grid) {
            int n=grid.length;
            DisjointSet ds=new DisjointSet(n*n);

            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        for(int index=0;index<4;index++){
                            int a=i+dr[index];
                            int b=j+dc[index];
                            if(a>=0 && a<n && b>=0 && b<n && grid[a][b]==1){
                                ds.unionBySize(formula(a,b,n),formula(i,j,n));
                            }
                        }
                    }
                }
            }
            int max=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==0){
                        HashSet<Integer> set=new HashSet<>();
                        for(int index=0;index<4;index++){
                            int a=i+dr[index];
                            int b=j+dc[index];
                            if(a>=0 && a<n && b>=0 && b<n && grid[a][b]==1){
                                set.add(ds.findUPar(formula(a,b,n)));
                            }
                        }
                        int temp=0;
                        for(int x : set){
                            temp+=ds.size.get(x);
                        }
                        max=Math.max(temp+1,max);
                    }
                }
            }
            for(int i=0;i<n*n;i++){
                max=Math.max(max,ds.size.get(ds.findUPar(i)));
            }
            return max;
        }



    public static void main(String[] args) {
        int[][]arr = {{1,1},{1,0}};
        System.out.println(largestIsland(arr));
    }
}
