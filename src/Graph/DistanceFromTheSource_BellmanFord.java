package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DistanceFromTheSource_BellmanFord {


    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dis = new int[V];
        Arrays.fill(dis, (int) 1e8);
        dis[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int n = it.get(0);
                int n2 = it.get(1);
                int wei = it.get(2);

                if (dis[n] != 1e8 && dis[n] + wei < dis[n2]) {
                    dis[n2] = dis[n] + wei;
                }
            }
        }

        for (ArrayList<Integer> it : edges) {
            int n = it.get(0);
            int n2 = it.get(1);
            int wei = it.get(2);

            if (dis[n] != 1e8 && dis[n] + wei < dis[n2]) {
                int[] ans = new int[1];
                ans[0] = -1;
                return ans;
            }
        }
        return dis;
    }


    public static void main(String[] args) {
        int V = 5;
        int S = 0;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(Arrays.asList(0, 1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2, 7)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 4)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4, -7)));

        int[] result = bellman_ford(V, edges, S);

        for (int dist : result) {
            System.out.print(dist + " ");
        }
    }
}