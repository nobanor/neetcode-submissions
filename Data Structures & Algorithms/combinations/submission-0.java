class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();

        backtrack(1, combinations, currCombination, n, k);

        return combinations;
        
    }

    private void backtrack(int index, List<List<Integer>> combinations, List<Integer> currCombination, int n, int k) {

        if(currCombination.size() == k) {
            combinations.add(new ArrayList<>(currCombination));
            return;
        } else if(index > n) {
            return;
        }

        currCombination.add(index);

        backtrack(index + 1, combinations, currCombination, n, k);

        currCombination.remove(currCombination.size() - 1);

        backtrack(index + 1, combinations, currCombination, n, k);
    }
}