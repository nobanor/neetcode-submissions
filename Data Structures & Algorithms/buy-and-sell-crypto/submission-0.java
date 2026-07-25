class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = Integer.MIN_VALUE;
        int currentPrice = prices[0];

        for(int i = 0; i < prices.length; i++) {
            int next = prices[i];
            maxProfit = Math.max(maxProfit, next - currentPrice);

            if(currentPrice > next) {
                currentPrice = next;
                continue;
            }
        }

        return maxProfit;
    }
}
