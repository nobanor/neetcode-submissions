class Solution {
    public void solve(char[][] board) {

        int ROWS = board.length;
        int COLS = board[0].length;

        for(int row = 0; row < ROWS; row++) {
            if(board[row][0] == 'O') {
                dfs(row, 0, board);
            }

            if(board[row][COLS - 1] == 'O') {
                dfs(row, COLS - 1, board);
            }
        }

        for(int col = 0; col < COLS; col++) {
            if(board[0][col] == 'O') {
                dfs(0, col, board);
            }  

            if(board[ROWS - 1][col] == 'O') {
                dfs(ROWS - 1, col, board);
            }
        }

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }


    }

    private void dfs(int row, int col, char[][] board) {

        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '#';

        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }
}
