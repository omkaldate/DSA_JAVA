package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_II {
    public static int[] findOrder(int v, int[][] pre){
        int m = pre.length;
        ArrayList<ArrayList<Integer>> list =  new ArrayList<>();
        for(int i=0; i<v; i++){
            list.add(new ArrayList<>());
        }

        //System.out.println(v + " " + pre.length + " " + pre[0].length);
        for(int j = 0; j<m; j++){
            list.get(pre[j][1]).add(pre[j][0]);
        }

        int[]indegree = new int[v];
        for(int x=0; x<v; x++){
            for(int y : list.get(x)) indegree[y]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int a=0; a<v;a++){
            if(indegree[a] == 0) q.add(a);
        }

        int[]topo = new int[v];
        int ind=0;
        while(! q.isEmpty()){
            int node = q.poll();
            topo[ind++] = node;

            for(int k : list.get(node)){
                indegree[k]--;
                if(indegree[k] == 0) q.add(k);
            }
        }

        if(ind == v) return topo;
        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] arr ={{1,0}};
        System.out.println(Arrays.toString(findOrder(2,arr)));
    }
}
