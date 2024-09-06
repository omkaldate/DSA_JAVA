package Graph;

import java.util.*;

public class EventualSafeStates_BFS {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

            int n = graph.length;
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0; i<n; i++) list.add(new ArrayList<>());

            for(int a=0; a<n; a++){
                for(int b=0; b<graph[a].length; b++){
                    list.get(a).add(graph[a][b]);
                }
            }

            List<List<Integer>> rev = new ArrayList<>();
            for(int i=0; i<n; i++) rev.add(new ArrayList<>());

            int[]indegree = new int[n];

            for(int j=0; j<n; j++){
                for(int it : list.get(j)){
                    rev.get(it).add(j);
                    indegree[j]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();

            for(int x=0; x<n; x++){
                if(indegree[x] == 0) q.add(x);
            }

            while(! q.isEmpty()){
                int node = q.poll();
                ans.add(node);

                for(int xx : rev.get(node)){
                    indegree[xx] --;
                    if(indegree[xx] == 0) q.add(xx);
                }
            }

        Collections.sort(ans);

        System.out.println(ans);
    }
}
