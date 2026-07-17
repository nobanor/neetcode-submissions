class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int leftNum = nums[i];
            int mid = i + 1;
            int right = nums.length - 1; 

            while(mid < right) {
                int midNum = nums[mid];
                int rightNum = nums[right];
                int sum = leftNum + midNum + rightNum;
                
                if(sum > 0) {
                    right--;
                } else if(sum < 0) {
                    mid++;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(leftNum, midNum, rightNum)));
                    mid++;
                    right--;
                }
            }
        }

        return new ArrayList(result);
        
    }
}
