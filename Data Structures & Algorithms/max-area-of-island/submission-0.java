class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        if(grid == null || grid.length == 0) {
            return maxArea;
        }

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 1) {
                    int currentArea = dfs(row, col, grid);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid) {

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;

        area += dfs(row + 1, col, grid);
        area += dfs(row - 1, col, grid);
        area += dfs(row, col + 1, grid);
        area += dfs(row, col - 1, grid);

        return area;
    }
}
