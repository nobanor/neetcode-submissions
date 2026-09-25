class Solution {
    public int numIslands(char[][] grid) {
        
        int numIslands = 0;

        if(grid == null || grid.length == 0) {
            return numIslands;
        }

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == '1') {
                    dfs(row, col, grid);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    private void dfs(int row, int col, char[][] grid) {

        //Base case
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
            return;
        }

        //Recursive case
        grid[row][col] = '0';
        
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}
