class Solution {
    public int[] getConcatenation(int[] nums) {

        int n = nums.length;
        int[] result = new int[n * 2];

        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            result[i] = curr;
            result[i + n] = curr;
        }

        return result;
    }
}