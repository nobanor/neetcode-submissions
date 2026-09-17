class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;
        boolean found = false;


        while(left <= right) {

            int midRow = left + (right - left) / 2; 

            if(matrix[midRow][0] > target) {
                right = midRow - 1;

            } else if(matrix[midRow][matrix[midRow].length - 1] < target) {
                left = midRow + 1; 
            } else {
                //Do Binary search on the row\
                int leftCol = 0;
                int rightCol = matrix[midRow].length - 1;

                while(leftCol <= rightCol) {
                    
                    int midCol = leftCol + (rightCol - leftCol) / 2;

                    if(matrix[midRow][midCol] < target) {
                        leftCol = midCol + 1;
                    } else if(matrix[midRow][midCol] > target) {
                        rightCol = midCol - 1;
                    } else {
                        found = true;
                        break;
                    }
                }
                break;
            }
        }
        
        return found;
    }
}
