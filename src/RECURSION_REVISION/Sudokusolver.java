package RECURSION_REVISION;

public class Sudokusolver {
    public static void main(String[] args) {
        char[][]mat = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

//        if(solve(mat)){
//            display(mat);
//        }
        solve(mat);
    }


   public static boolean solve(char[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            // if you found some empty element in row, then break

            if(!emptyLeft){
                break;
            }
        }

        if(emptyLeft){
            return true;
        }

        // Backtrack

        for (char number = '1'; number <= '9'; number++) {
            if(isSafe(board, row, col, number)){
                board[row][col] = number;
                if(solve(board)){
                    display(board);
                    System.out.println();
                    return true;
                }
                else board[row][col] = '.';
            }
        }
        return false;
    }

    private static void display(char[][] board) {
        for (char[] row : board){
            for(char num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] board, int row, int col, char num){
        // check the row
        for (int i = 0; i < board.length; i++) {
            // check if number is in board

            if(board[row][i] == num){
                return false;
            }
        }

        // check the col
        for (int i = 0; i < board.length; i++) {
            // check if number is in board

            if(board[i][col] == num){
                return false;
            }
        }

        // check the particular box;
        int sqrt = (int) Math.sqrt(board.length);
        int start = row - (row % sqrt);
        int end = col - (col % sqrt);

        for (int r = start; r < (start + sqrt); r++) {
            for (int c = end; c < (end + sqrt) ; c++) {
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
