package Graph;

import java.util.Arrays;

public class OsandXs {

    public static void DFS(int row, int col, int[][]vis , int[]dx, int[]dy, char[][]mat){
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<4; i++){
            int r = row +dx[i];
            int c = col +dy[i];

            if(r <0 || r >=n || c <0 || c>=m) continue;
            if(vis[r][c] == 0 && mat[r][c] == 'O'){
                DFS(r,c,vis,dx,dy,mat);
            }
        }

    }

    public static char[][] solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[]dx = {-1,0,1,0};
        int[]dy = {0,1,0,-1};
        int[][]vis = new int[n][m];

        for(int j=0; j<m; j++){
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                DFS(0,j,vis,dx,dy,board);
            }

            if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
                DFS(n-1,j,vis,dx,dy,board);
            }
        }

        for(int i=0; i<n; i++){
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                DFS(i,0,vis,dx,dy,board);
            }

            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                DFS(i,m-1,vis,dx,dy,board);
            }
        }

        for(int a =0; a<n; a++){
            for(int b =0; b<m; b++){
                if(vis[a][b] == 0 && board[a][b] == 'O'){
                    board[a][b] = 'X';
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][]board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        board = solve(board);

        for(char[]x : board){
            System.out.println(Arrays.toString(x));
        }
    }
}
