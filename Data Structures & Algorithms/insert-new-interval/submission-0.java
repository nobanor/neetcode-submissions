class Solution {
 
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> finalIntervals = new ArrayList<>();

        for(int[] interval : intervals) {

            int currStart = interval[0];
            int currEnd = interval[1];

            //Add before 
            if(newInterval == null || currEnd < newInterval[0]) {
                finalIntervals.add(interval);
            } else if(currStart > newInterval[1]) {
                finalIntervals.add(newInterval);
                finalIntervals.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(currStart, newInterval[0]);
                newInterval[1] = Math.max(currEnd, newInterval[1]);
            }
        }


        if(newInterval != null) {
            finalIntervals.add(newInterval);
        }

        return finalIntervals.toArray(new int[finalIntervals.size()][]);
    }
}
