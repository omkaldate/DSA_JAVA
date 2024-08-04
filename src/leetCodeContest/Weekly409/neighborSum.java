package leetCodeContest.Weekly409;

public class neighborSum {
    int[][] grid;

    public neighborSum(int[][] grid) {
        this.grid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public int[] index(int val) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == val) return new int[]{i, j};
            }
        }
        return new int[]{-1};
    }

    public int adjacentSum(int value) {
        int sum = 0;

        int[] id = index(value);
        if (id.length == 1) return -1;
        int n = id[0];
        int m = id[1];

        if (m > 0) sum += grid[n][m - 1];
        if (n > 0) sum += grid[n - 1][m];
        if (m < grid[0].length - 1) sum += grid[n][m + 1];
        if (n < grid.length - 1) sum += grid[n + 1][m];

        return sum;
    }

    public int diagonalSum(int value) {
        int sum = 0;

        int[] id = index(value);
        if (id.length == 1) return -1;
        int n = id[0];
        int m = id[1];

        if (n > 0 && m > 0) sum += grid[n - 1][m - 1];
        if (n < grid.length - 1 && m > 0) sum += grid[n + 1][m - 1];
        if (n < grid.length - 1 && m < grid[0].length - 1) sum += grid[n + 1][m + 1];
        if (n > 0 && m < grid[0].length - 1) sum += grid[n - 1][m + 1];

        return sum;
    }


    public static void main(String[] args) {
        int[][]arr ={
            {0,1,2},
            {3,4,5},
            {6,7,8}
        };
        neighborSum obj = new neighborSum(arr);
        int param_1 = obj.adjacentSum(4);
        System.out.println(param_1);
    }
}

