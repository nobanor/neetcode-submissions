class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int[][] coords = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 0) {
                    queue.add(new int[] {row, col});
                }
            }
        }

        int level = 1;
        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] currCord = queue.poll();
                int currRow = currCord[0];
                int currCol = currCord[1];

                for(int[] coord : coords) {
                    int nextRow = currRow + coord[0];
                    int nextCol = currCol + coord[1];
                    int[] nextCoord = new int[]{nextRow, nextCol};

                    if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[nextRow].length || grid[nextRow][nextCol] != Integer.MAX_VALUE) {
                        continue;
                    }

                    grid[nextRow][nextCol] = level;
                    queue.offer(nextCoord);
                }
            }

            level++;
        }
    }
}
