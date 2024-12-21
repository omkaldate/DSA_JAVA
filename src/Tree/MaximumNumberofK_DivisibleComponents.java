package Tree;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberofK_DivisibleComponents {
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] count = new int[1];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(adj, values, k, count, -1, 0);
        return count[0];
    }

    private static int dfs(List<List<Integer>> adj, int[] values, int k, int[] count, int parent, int current) {
        int sum = values[current];

        for (int neighbor : adj.get(current)) {
            if (neighbor != parent) {
                sum += dfs(adj, values, k, count, current, neighbor);
            }
        }
        if (sum % k == 0) {
            count[0]++;
        }

        return sum % k;
    }


    public static void main(String[] args) {

    }
}
