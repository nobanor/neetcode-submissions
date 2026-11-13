class Logger {

    private Map<String, Integer> messageTimeMap;

    public Logger() {
        this.messageTimeMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {

        if (messageTimeMap.containsKey(message) && timestamp < messageTimeMap.get(message)) {
            return false;
        }

        messageTimeMap.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
