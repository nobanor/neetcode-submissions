class Solution {
    public int countPaths(int[][] grid) {

        int pathCount = 0;

        if(grid == null || grid.length == 0) {
            return pathCount;
        }

        Set<String> seen = new HashSet<>();


        //DFS 
        pathCount = dfs(grid, 0, 0, seen);
        return pathCount;
    }

    private int dfs(int[][] grid, int row, int col, Set<String> seen) {

        //Base case
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || seen.contains(row + "," + col) || grid[row][col] == 1) {
            return 0;
        }

        if(row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        seen.add(row + "," + col);

        int count = 0;

        count += dfs(grid, row + 1, col, seen);
        count += dfs(grid, row - 1, col, seen);
        count += dfs(grid, row, col + 1 , seen);
        count += dfs(grid, row, col - 1, seen);

        seen.remove(row + "," + col);

        return count;
    }
}
