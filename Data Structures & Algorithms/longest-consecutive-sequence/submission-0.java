class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int longestSequence = 0;

        for(int num : nums) {

            if(!set.contains(num - 1)) {
                int currLongest = 1;

                while(set.contains(num + 1)){
                    currLongest++;
                    num++;
                }

                longestSequence = Math.max(currLongest, longestSequence);
            }
        }

        return longestSequence;
        
    }
}
