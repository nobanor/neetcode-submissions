class HitCounter {

    private Queue<Integer> hitTimestamps;

    public HitCounter() {
        this.hitTimestamps = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        hitTimestamps.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        //Remove anything less than timestamp - 300
        while(! hitTimestamps.isEmpty() && hitTimestamps.peek() <= timestamp - 300) {
            hitTimestamps.remove();
        }

        return hitTimestamps.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
