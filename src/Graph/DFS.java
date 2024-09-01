package Graph;

import java.util.ArrayList;

public class DFS {

    public static void printDFS(ArrayList<ArrayList<Integer>> list,int n, int[]vis){
        vis[n] = 1;
        System.out.print(n);

        for(int i : list.get(n)){
            if(vis[i] == 0){
                printDFS(list,i,vis);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arr.add(new ArrayList<>());
        }
        arr.get(1).add(2);
        arr.get(2).add(1);

        arr.get(2).add(3);
        arr.get(3).add(2);

        arr.get(3).add(1);
        arr.get(1).add(3);

        int []vis = new int[arr.size()+1];
        printDFS(arr,1,vis);
    }
}
