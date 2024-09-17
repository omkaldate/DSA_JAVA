package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MostStonesRemovedwithSamerowOrColumn {
    static class Disjoint {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        Disjoint(int n) {
            for (int i = 0; i <= n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node))
                return node;

            int save = findParent(parent.get(node));
            parent.set(node, save);
            return save;
        }

        public void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv)
                return;
            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, (size.get(pu) + size.get(pv)));
            } else {
                parent.set(pv, pu);
                size.set(pu, (size.get(pu) + size.get(pv)));
            }
        }
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        int rowMax = 0;
        int colMax = 0;

        for (int i = 0; i < n; i++) {
            rowMax = Math.max(rowMax, stones[i][0]);
            colMax = Math.max(colMax, stones[i][1]);
        }
        Disjoint ds = new Disjoint(rowMax + colMax+1);

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + rowMax + 1;
            ds.union(nodeRow, nodeCol);
            set.add(nodeRow);
            set.add(nodeCol);
        }
        int cnt = 0;
        for (int x : set) {
            if (ds.findParent(x) == x) cnt++;
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {0,0},
                {1,0},
                {0,1},
                {1,2},
                {2,2},
                {2,1}
        };

        System.out.println(removeStones(arr));
    }
}
