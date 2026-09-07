class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> winMap = new HashMap<>();

        for(char c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) +1);
        }

        int left = 0;
        int minLeft = 0;
        int formed = 0;
        String minString = "";
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if(freqMap.containsKey(c)) {
                winMap.put(c, winMap.getOrDefault(c, 0) + 1);

                if(freqMap.get(c).equals(winMap.get(c))) {
                    formed++;
                }
            }

            while(formed == freqMap.size()) {

                if(right - left + 1 < minLength) {
                    minLeft = left;
                    minLength = right - left + 1;
                }

                char leftChar = s.charAt(left);

                if(freqMap.containsKey(leftChar)) {

                    if(winMap.get(leftChar).equals(freqMap.get(leftChar))) {
                        formed--;
                    }

                    winMap.put(leftChar, winMap.get(leftChar) - 1);
                }

                left++;
            }
        } 

        return minLength == Integer.MAX_VALUE
            ? ""
            : s.substring(minLeft, minLeft + minLength);
    }
}
