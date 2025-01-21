package matrix;

public class GridGame {
    public static long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[]sufix = new long[n];
        long[]prefix = new long[n];

        long sum = 0;
        for(int i=0; i<n; i++){
            sum += grid[1][i];
            prefix[i] = sum;
        }

        sum = 0;
        for(int i=n-1; i>=0; i--){
            sum += grid[0][i];
            sufix[i] = sum;
        }

        // System.out.println( Arrays.toString(sufix));
        // System.out.println( Arrays.toString(prefix));

        long ans = Long.MAX_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.min(ans, Math.max((sufix[i] - grid[0][i])  , (prefix[i]- grid[1][i])));
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
