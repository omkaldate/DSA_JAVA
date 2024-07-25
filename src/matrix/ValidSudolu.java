package matrix;

public class ValidSudolu {
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    if(!isSafe(board, i, j, board[i][j])) return false;
                }
            }
        }

        return true;
    }

    public static boolean isSafe(char[][] board, int row, int col, char num){
        for (int i = 0; i < board.length; i++) {
            if(i != col && board[row][i] == num){
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if(row != i && board[i][col] == num){
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(board.length);
        int start = row - (row % sqrt);
        int end = col - (col % sqrt);

        for (int r = start; r < (start + sqrt); r++) {
            for (int c = end; c < (end + sqrt) ; c++) {
                if(board[r][c] == num){
                    if(r == row && c == col) continue;
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
    }
}
