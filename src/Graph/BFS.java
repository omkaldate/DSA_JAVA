package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void printBFS(ArrayList<ArrayList<Integer>> list){
        int n = list.size();
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(2);
        vis[2] = 1;

        while(!q.isEmpty()){
            int val = q.poll();
            System.out.print(val +" ");

            for(int i: list.get(val)){
                if(vis[i] == 0){
                    vis[i] = 1;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i=0; i<10; i++){
            arr.add(new ArrayList<>());
        }
        arr.get(1).add(2);
        arr.get(2).add(1);

        arr.get(2).add(3);
        arr.get(3).add(2);

        arr.get(3).add(1);
        arr.get(1).add(3);

        printBFS(arr);
    }
}
