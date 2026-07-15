class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> set = new HashSet<>();

        for(int i = 0; i < board.length; i++) {

            for(int j = 0; j < board[i].length; j++) {

                char current = board[i][j];

                if(current != '.') {
                    String inRow = current + " in row: " + i;
                    String inCol = current + " in col: " + j;
                    String inBox = current + " in box: " + i/3 + "-" + j/3;

                    if(set.contains(inRow) || set.contains(inCol) || set.contains(inBox)) {
                    return false; 
                    }

                    set.add(inRow);
                    set.add(inCol);
                    set.add(inBox);
                }
            }
        }

        return true; 
    }
}
