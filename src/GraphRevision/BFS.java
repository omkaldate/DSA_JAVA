package GraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfsFun(ArrayList<ArrayList<Integer>> list, int n){
        int len = list.size();
        int[]vis = new int[len];

        Queue<Integer> q  = new LinkedList<>();
        q.offer(n);
        vis[n] = 1;

        while(!q.isEmpty()){
            int val = q.poll();
            System.out.println(val);

            for(int x : list.get(val)){
                if(vis[x] == 0){
                    vis[val] = 1;
                    q.offer(x);
                }
            }
        }

    }


    public static void dfsFun(ArrayList<ArrayList<Integer>> list , int n){
        int[]vis = new int[list.size()];
        rec(list,n,vis);
    }

    public static void rec(ArrayList<ArrayList<Integer>> list, int i, int[]vis){
        vis[i] = 1;
        System.out.println(i);

        for(int x : list.get(i)){
            if(vis[x] == 0){
                rec(list, x, vis);
            }
        }
    }


    public static void main(String[] args) {
        int[][]arr = new int[4][4];

        arr[1][2] = 1;
        arr[2][1] = 1;
        arr[3][1] = 1;
        arr[1][3] = 1;
        arr[2][3] = 1;
        arr[3][2] = 1;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int n = arr.length;

        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int j =0; j<n; j++){
            for(int x=0; x<n; x++){
                if(arr[j][x] == 1){
                    list.get(j).add(x);
                }
            }
        }

        for(ArrayList<Integer> z : list){
            System.out.println(z);
        }

       // bfsFun(list , 2);
        dfsFun(list, 3);

    }
}
