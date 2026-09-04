class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> triplets = new HashSet<>();
        Arrays.sort(nums);

        //Loop and compare nums at three pointers
        for(int left = 0; left < nums.length - 2; left++) {

            int mid = left + 1;
            int right = nums.length - 1;

            while (mid < right) {

                int target = nums[left] + nums[mid] + nums[right];

                if(target == 0) {
                    triplets.add(new ArrayList<>(Arrays.asList(nums[left], nums[mid], nums[right])));
                    mid++;
                    right--;
                } else if(target > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }

        return new ArrayList<>(triplets);
    }
}
