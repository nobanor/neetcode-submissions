class Solution {
    public int maxArea(int[] heights) {

        /**
        1. Set two pointers left and right
        2. Calculate distance between pointers and compute area based on smaller height
        3. Keep track of maxArea so far 
        4. Move the pointer from smaller height 
        */

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while(left < right) {
            int distance = right - left;
            int currentArea = Math.min(heights[left], heights[right]) * distance;
            maxArea = Math.max(maxArea, currentArea);

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
