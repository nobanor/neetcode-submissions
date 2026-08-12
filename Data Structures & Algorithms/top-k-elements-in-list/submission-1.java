class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> frequencyMap = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            frequencyMap.put(current, frequencyMap.getOrDefault(current, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }


        for(int num : frequencyMap.keySet()) {
            int numFrequency = frequencyMap.get(num);
            buckets.get(numFrequency).add(num);
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for(int frequency = buckets.size() - 1; frequency >= 0 && resultIndex < k; frequency--) {
            
            // There could be multiple numbers with the same frequency.
            for (int num : buckets.get(frequency)) {

                result[resultIndex] = num;
                resultIndex++;

                // We only need the top k numbers.
                if (resultIndex == k) {
                    break;
                }
            }
        }

        return result;
    }
}
