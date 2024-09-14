package leetCodeContest.BIweekly139;

import java.util.*;

public class FindASafeWalkThroughSGrid {

    static class Triple {
        int row, col, health;

        public Triple(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        if(grid.get(0).get(0) == 1) health--;
        Queue<Triple> queue = new LinkedList<>();
        queue.offer(new Triple(0, 0, health));

        Set<String> visited = new HashSet<>();
        visited.add(0 + "," + 0 + "," + health);

        while (!queue.isEmpty()) {
            Triple current = queue.poll();
            int i = current.row;
            int j = current.col;
            int h = current.health;

            if (i == m - 1 && j == n - 1 && h > 0) return true;


            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int newHealth = h - (grid.get(ni).get(nj) == 1 ? 1 : 0);

                    if (newHealth > 0 && !visited.contains(ni + "," + nj + "," + newHealth)) {
                        visited.add(ni + "," + nj + "," + newHealth);
                        queue.offer(new Triple(ni, nj, newHealth));
                    }
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {

    }

}


