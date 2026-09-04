class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int minValue = prices[0];

        for(int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - minValue;
            maxProfit = Math.max(maxProfit, currentProfit);
            minValue = Math.min(minValue, prices[i]);
        }

        return maxProfit;
        
    }
}
