class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int weight = time[2];
            adj.get(src).add(new int[]{dest, weight});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));    
        minHeap.add(new int[] {0, k});
        Map<Integer, Integer> shortest = new HashMap<>();

        while(!minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int w1 = pair[0];
            int n1 = pair[1];

            if(shortest.containsKey(n1)) {
                continue;
            }

            shortest.put(n1, w1);

            List<int[]> neighbors = adj.get(n1);

            for(int[] neighbor : neighbors) {
                int n2 = neighbor[0];
                int w2 = neighbor[1];

                if(!shortest.containsKey(n2)) {
                    minHeap.add(new int[] {(w1 + w2), n2});
                }
            }
        }

        int maxTime = 0;

        if(shortest.size() < n) {
            return -1;
        }

        for(int dist : shortest.values()) {
            maxTime = Math.max(maxTime, dist);
        }

        return maxTime;
    }
}
