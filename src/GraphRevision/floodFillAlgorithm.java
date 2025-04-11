package GraphRevision;

public class floodFillAlgorithm {

    public static void dfs(int[][]image, int sr, int sc, int color, int[][]side, int replace){
        int n = image.length;
        int m = image[0].length;

        image[sr][sc] = color;

        for(int[]x : side){
            int row = sr + x[0];
            int col = sc + x[1];

            if(row>=n || row <0 || col <0 || col>=m) continue;
            if(image[row][col] == replace){
                dfs(image,row,col,color,side,replace);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int x = image[sr][sc];
        if (x == color) return image;
        int[][]side = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        dfs(image, sr, sc, color,side,x);
        return image;
    }


    public static void main(String[] args) {

    }
}
