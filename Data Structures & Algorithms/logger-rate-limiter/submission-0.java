class Logger {

    private Map<String, Integer> messageTimeMap;

    public Logger() {
        this.messageTimeMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {

        
        //Check if message is in the map
        if(!messageTimeMap.containsKey(message)) {
            messageTimeMap.put(message, timestamp + 10);
        } else { 

            int prevTimestamp = messageTimeMap.get(message);
            if(timestamp < prevTimestamp) {
                return false;
            } else {
                messageTimeMap.put(message, timestamp + 10);
            }
        }

        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
