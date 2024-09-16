package Graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands_II {

    static class Disjoint_UnionRank {
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
    }



    public static List<Integer> numOfIslands(int n, int m, int[][] operators) {
        int[][]vis = new int[n][m];
        Disjoint_UnionRank ds = new Disjoint_UnionRank(n*m);

        int cnt =0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;

        for(int i=0; i<len; i++){
            int row = operators[i][0];
            int col = operators[i][1];
            if(vis[row][col] == 1){
                ans.add(cnt);
                continue;
            }

            vis[row][col] =1;
            cnt++;

            int[]dx = {-1,0,1,0};
            int[]dy = {0,1,0,-1};

            for(int j=0; j<4; j++){
                int r = row + dx[j];
                int c = col + dy[j];

                if(r <0 || r>=n || c <0 || c >=m) continue;

                if(vis[r][c] == 1){
                    int n1 = row*m+col;
                    int n2 = r*m+c;
                    if(ds.findParent(n1) != ds.findParent(n2)){
                        cnt--;
                        ds.union(n1,n2);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][]queri = {{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3}};

        System.out.println(numOfIslands(4,5,queri));
    }
}
