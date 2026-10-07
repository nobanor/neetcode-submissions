class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        Set<List<Integer>> subsets = new HashSet<>();
        List<Integer> currSubsets = new ArrayList<>();

        backtrack(0, subsets, currSubsets, nums);

        return new ArrayList<>(subsets);
    }

    public void backtrack(int i, Set<List<Integer>> subsets, List<Integer> currSubsets, int[] nums) {

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
