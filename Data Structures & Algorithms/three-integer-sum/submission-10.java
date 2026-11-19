class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        Set<List<Integer>> triplets = new HashSet<>();

        //Go through nums 
        for(int left = 0; left < nums.length - 2; left++) {

            //Two pointers 
            int mid = left + 1;
            int right = nums.length - 1;

            while(mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];

                if(sum > 0) {
                    right--;
                } else if(sum < 0) {
                    mid++;
                } else {
                    triplets.add(new ArrayList<>(Arrays.asList(nums[left], nums[mid], nums[right])));
                    mid++;
                    right--;
                }
            }
        }

        return new ArrayList<>(triplets);
    }
}
