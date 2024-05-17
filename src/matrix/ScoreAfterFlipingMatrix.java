package matrix;

public class ScoreAfterFlipingMatrix {
    public static int matrixScore(int[][] grid) {
        if (grid.length <= 1 && grid[0].length <= 1) return 1;
        int sum = 0;
        int sum2 = 0;

        for (int i = 0; i < grid.length; i++) {
            int x=grid[i][0 ];
            for (int j = 0; j < grid[0].length; j++) {
                if (x == 0) {
                    grid[i][j] = grid[i][j] ^ 1;
                }
                sum += grid[i][j] * Math.pow(2, grid[0].length - j - 1);
            }
        }

        int result = 0;
        for (int i =0; i<grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[j][i] == 1) result++;
            }
            if (result <= grid.length/2) {
                for (int j = 0; j < grid.length; j++) {
                    grid[j][i] = grid[j][i] ^ 1;
                }
            }
            result =0;
        }

        for (int i =0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum2 += grid[i][j] * Math.pow(2, grid[0].length - j - 1);
            }
        }
        //System.out.println(sum);
        //System.out.println(sum2);

        return Math.max(sum , sum2);
    }


    public static void main(String[] args){
        int[][]arr = {
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        System.out.println(matrixScore(arr));
    }
}
