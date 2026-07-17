class Solution {
    public int maxArea(int[] heights) {

        //1. Left pointer and right pointer
        //2. Calculate area water storage (min height * distance between bars)
        //3. Move the pointer from the smaller bar 
        //4. Keep calculating and keeping count of max 

        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;

        while(left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            int distance = right - left;
            int currentWater = Math.min(leftHeight, rightHeight) * distance;
            
            maxWater = Math.max(maxWater, currentWater);

            if(leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
