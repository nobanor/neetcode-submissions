class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] result = new int[k];

        //Build frequency map first
        Map<Integer, Integer> frequencyMap = new HashMap<>(); 
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(frequencyMap.get(a), frequencyMap.get(b)));

        for(int num : frequencyMap.keySet()) {
            heap.add(num);

            if(heap.size() > k) {
                heap.remove();
            }
        }

        List<Integer> temp = new ArrayList<>();

        while(!heap.isEmpty()) {
            temp.add(heap.poll());
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }

        return result;
    }
}
