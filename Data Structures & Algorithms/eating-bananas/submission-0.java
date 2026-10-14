class Solution {

    //[4, 10, 23, 25]
    // piles <= h

    public int minEatingSpeed(int[] piles, int h){

        Arrays.sort(piles);
        int max = piles[piles.length - 1];

        int left = 1;
        int right = max;
        int minK = Integer.MAX_VALUE;

        while(left <= right) {

            int mid = left + (right - left) / 2;
            long rate = 0;

            for(int pile : piles) {
                rate += (pile + mid - 1L) / mid;
            }

            if(rate <= h) {
                minK = Math.min(minK, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minK;
        
    }
}
