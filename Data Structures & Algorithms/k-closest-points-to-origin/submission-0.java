class Solution {
    public int[][] kClosest(int[][] points, int k) {

        //(sqrt((x1 - x2)^2 + (y1 - y2)^2))
        //Iterate through 2-D array, and calculate distance
        //Keep K closest in a heap
        //How to make sure only K are kept in heap?

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        for(int[] point : points) {
            maxHeap.add(point);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result; 
    }
}
