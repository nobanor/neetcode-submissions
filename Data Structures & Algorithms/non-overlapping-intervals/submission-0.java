class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = intervals[0];
        int prevEnd = prev[1];
        int minRemove = 0;

        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int currStart = curr[0];
            int currEnd = curr[1];

            if(currStart < prevEnd) {
                prevEnd = Math.min(prevEnd, currEnd);
                minRemove++;
            } else {
                prevEnd = currEnd;
            }
        }

        return minRemove; 
        
    }
}
