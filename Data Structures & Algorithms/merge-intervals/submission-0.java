class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];

        for(int i = 1; i < intervals.length; i++) {

            int prevStart = prev[0];
            int prevEnd = prev[1];
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            //Check if prev needs to be added 
            if(prevEnd < currStart) {
                result.add(prev);
                prev = intervals[i];
            } else {
                prev[1] = Math.max(prevEnd, currEnd);
            }
        }

        result.add(prev);
        return result.toArray(new int[result.size()][]);
    }
}
