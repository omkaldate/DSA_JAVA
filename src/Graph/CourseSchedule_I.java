package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_I {
    public static boolean canFinish(int v, int[][] pre) {
        ArrayList<ArrayList<Integer>> list =  new ArrayList<>();
        for(int i=0; i<v; i++){
            list.add(new ArrayList<>());
        }

        System.out.println(v + " " + pre.length + " " + pre[0].length);
        for(int j = 0; j<pre.length; j++){
            list.get(pre[j][0]).add(pre[j][1]);
        }

        int[]indegree = new int[v];
        for(int x=0; x<v; x++){
            for(int y : list.get(x)) indegree[y]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int a=0; a<v;a++){
            if(indegree[a] == 0) q.add(a);
        }

        List<Integer> ans = new ArrayList<>();

        while(! q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int k : list.get(node)){
                indegree[k]--;
                if(indegree[k] == 0) q.add(k);
            }
        }

        if(ans.size() == v) return true;
        return false;
    }


    public static void main(String[] args) {
        int[][] arr ={{1,0},{0,1}};
        System.out.println(canFinish(2,arr));
    }
}
