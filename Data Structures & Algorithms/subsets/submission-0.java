class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currSubsets = new ArrayList<>();

        backtrack(0, subsets, currSubsets, nums);

        return subsets;
    }

    public void backtrack(int i, List<List<Integer>> subsets, List<Integer> currSubsets, int[] nums) {

        if(i >= nums.length) {
            subsets.add(new ArrayList<>(currSubsets));
            return;
        }

        currSubsets.add(nums[i]);

        backtrack(i + 1, subsets, currSubsets, nums);

        currSubsets.remove(currSubsets.size() - 1);

        backtrack(i + 1, subsets, currSubsets, nums);
    }
}
