class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //Create map - num to index and search for difference
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            
            //Check difference 
            int diff = target - nums[i];
            
            if(numToIndexMap.get(diff) != null) {
                 result[0] = numToIndexMap.get(diff);
                 result[1] = i;
                 break;
            }

            numToIndexMap.put(nums[i], i);
        }

        return result;
        
    }
}
