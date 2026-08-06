class Solution {
    public int numIslands(char[][] grid) {

        int numIslands = 0;

        if(grid == null || grid.length == 0) {
            return numIslands;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i , j);
                    numIslands += 1;
                }
            }
        }

        return numIslands; 
    }

    private void dfs(char[][] grid, int row, int col) {

        //Base case
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);


    }


}
