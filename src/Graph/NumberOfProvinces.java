package Graph;

import java.util.ArrayList;

public class NumberOfProvinces {

    public static void BFS(ArrayList<ArrayList<Integer>> list , int[]vis , int n){
        vis[n] = 1;

        for(int i : list.get(n)){
            if(vis[i] == 0){
                BFS(list,vis,i);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int a=0; a<n; a++){
            for(int j=0; j<n; j++){
                if(isConnected[a][j] == 1 && a!=j) {
                    list.get(a).add(j);
                }
            }
        }

        int[]vis = new int[n];
        int cnt =0;

        for(int x =0; x<n; x++){
            if(vis[x] == 0){
                cnt++;
                BFS(list,vis,x);
            }
        }
        return cnt;
    }



    public static void main(String[] args) {
        int[][]matrix = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(matrix));
    }
}
