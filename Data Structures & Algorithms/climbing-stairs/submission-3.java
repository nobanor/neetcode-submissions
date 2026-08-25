class Solution {
    public int climbStairs(int n) {

        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 0; i < n - 1; i++) {
            int temp = dp[0];
            dp[0] = dp[0] + dp[1];
            dp[1] = temp;
        }

        return dp[0];
    }
}
