class Solution {
    public int orangesRotting(int[][] grid) {

        int minutes= 0;
        int fresh = 0;
        Queue<int[]> rotten = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    rotten.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(fresh > 0 && !rotten.isEmpty()) {

            int size = rotten.size();

            for(int i = 0; i < size; i++) {
                int[] current = rotten.poll();

                for(int[] dir : dirs) {
                    int currRow = current[0];
                    int currCol = current[1];
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];

                    if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || grid[nextRow][nextCol] == 0 || grid[nextRow][nextCol] == 2) {
                        continue;
                    }

                    grid[nextRow][nextCol] = 2;
                    rotten.offer(new int[] {nextRow, nextCol});
                    fresh--;
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
