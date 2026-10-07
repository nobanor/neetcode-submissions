class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(0, 0, combinations, currCombination, nums, target);

        return combinations;
    }

    private void backtrack(int i, int currSum, List<List<Integer>> combinations, List<Integer> currCombination, int[] nums, int target) {

        if(currSum == target) {
            combinations.add(new ArrayList<>(currCombination));
            return;
        }

        for(int j = i; j < nums.length; j++) {
            if(currSum + nums[j] > target) {
                return;
            }

            currCombination.add(nums[j]);
            backtrack(j, currSum + nums[j], combinations, currCombination, nums, target);
            currCombination.remove(currCombination.size() - 1);
        }

    }
}
