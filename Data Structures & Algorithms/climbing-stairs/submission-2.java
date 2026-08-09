class Solution {
    public int climbStairs(int n) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int numWays =  findNumWays(map, 0, n);
        return numWays;
    }

    private int findNumWays(Map<Integer, Integer> map, int currentSteps, int n) {

        if(map.get(currentSteps) != null) {
            return map.get(currentSteps);
        }

        if(currentSteps > n) {
            return 0;
        }

        if(currentSteps == n) {
            return 1;
        }

        int numWays = 0;

        numWays += findNumWays(map, currentSteps + 1, n);
        numWays += findNumWays(map, currentSteps + 2, n);
        map.put(currentSteps, numWays);

        return numWays;
    }
}
