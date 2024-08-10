package matrix;

public class RegionCutBySlashes {

    public static void dfs(int[][] arr, int n, int m, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m || arr[i][j] == 1) {
            return;
        }

        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        arr[i][j] = 1;

        for(int z = 0; z < 4; z++) {
            dfs(arr,n,m,i+dx[z],j+dy[z]);
        }

    }
    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        int matrix[][] = new int[n*3][m*3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char ch = grid[i].charAt(j);
                if(ch == '/') {
                    matrix[i*3][j*3+2] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3] = 1;
                }
                else if(ch == '\\') {
                    matrix[i*3][j*3] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3+2] = 1;
                }
            }
        }

        int regions = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    regions++;
                    dfs(matrix,matrix.length,matrix[0].length,i,j);
                }
            }
        }

        return regions;
    }


    public static void main(String[] args) {
        String[]s = {"/\\","\\/"};
        System.out.println(regionsBySlashes(s));
    }
}
