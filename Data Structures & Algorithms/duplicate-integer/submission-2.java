class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        boolean hasDuplicate = false;
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums) {
            if(numSet.contains(num)) {
                hasDuplicate = true;
                break;
            }
            numSet.add(num);
        }

        return hasDuplicate;
    }
}