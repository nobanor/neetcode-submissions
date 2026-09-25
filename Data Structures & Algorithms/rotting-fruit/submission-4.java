class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[][] coords = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int minutes = 0;
        int fresh = 0;

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 2) {
                    queue.offer(new int[] {row, col});
                }

                if(grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        while(fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for(int[] coord : coords) {
                    int currRow = curr[0];
                    int currCol = curr[1];
                    int nextRow = currRow + coord[0];
                    int nextCol = currCol + coord[1];

                    if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[nextRow].length || grid[nextRow][nextCol] != 1) {
                        continue;
                    }

                    grid[nextRow][nextCol] = 2;
                    queue.offer(new int[] {nextRow, nextCol});
                    fresh--;
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;

    }
}
