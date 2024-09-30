package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCriticalAndPsudoCriticalEdgesInMST {

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find (int x) {
            if (x == parent[x]) return x;
            int save = find(parent[x]);
            parent[x] = save;
            return save;
        }

        public void Union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent == y_parent) return;

            if(rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            }
            else if(rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            }
            else {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }

        }
    }

    static int N;

    public static int Kruskal(int[][] vec, int skip_edge, int add_edge) {

        int sum = 0;

        UnionFind uf = new UnionFind(N);
        int edgesConnected = 0;

        if(add_edge != -1) {
            uf.Union(vec[add_edge][0], vec[add_edge][1]);
            sum += vec[add_edge][2];
            edgesConnected++;
        }


        for(int i = 0; i<vec.length; i++) {
            if(i == skip_edge) continue;

            int u  = vec[i][0];
            int v  = vec[i][1];
            int wt = vec[i][2];

            int parent_u = uf.find(u);
            int parent_v = uf.find(v);

            if(parent_u != parent_v) {
                uf.Union(u, v);
                edgesConnected++;
                sum += wt;
            }

        }

        if(edgesConnected != N-1) return Integer.MAX_VALUE;

        return sum;
    }

    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        N = n;

        int m = edges.length;
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        int MST_WEIGHT = Kruskal(newEdges, -1, -1);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            if(Kruskal(newEdges, i, -1) > MST_WEIGHT) {
                result.get(0).add(newEdges[i][3]);
            }

            else if(Kruskal(newEdges, -1, i) == MST_WEIGHT) {
                result.get(1).add(newEdges[i][3]);
            }

        }

        return result;
    }


    public static void main(String[] args) {

    }
}
