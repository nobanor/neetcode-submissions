class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int difference = target - current; 

            if(numToIndexMap.containsKey(difference)) {
                result[0] = numToIndexMap.get(difference);
                result[1] = i;
                break;
            }

            numToIndexMap.put(current, i);
        }

        return result;
    }
}
