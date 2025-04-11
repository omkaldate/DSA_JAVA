package GraphRevision;

import java.util.ArrayList;

public class numberOfprovices {


    public static void dfs(ArrayList<ArrayList<Integer>> list , int i, int[]vis){
        vis[i] = 1;

        for(int x : list.get(i)){
            if(vis[x] == 0) dfs(list, x, vis);
        }
    }


    public static int findCircleNum(int[][] arr) {
        int n = arr.length;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());

        for(int j=0; j<n; j++){
            for(int x = 0; x<n; x++){
                if(arr[j][x] == 1) list.get(j).add(x);
            }
        }

        int cnt = 0;
        int[]vis = new int[n];
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(list,i,vis);
                cnt++;
            }
        }

        return cnt;
    }


    public static void main(String[] args) {
        int[][]arr = new int[4][4];

        arr[1][2] = 1;
        arr[2][1] = 1;
        arr[3][1] = 1;
        arr[1][3] = 1;
        arr[2][3] = 1;
        arr[3][2] = 1;

        System.out.println(findCircleNum(arr));
    }
}
