class Solution {
    public int characterReplacement(String s, int k) {

        /*
        - Use frequency map to keep track of char to frequency
        - Two pointers to create a window
        - Move right pointer and update frequencyt
        - Check the windowLength - current char frequency <= k
            - if its less, update longest by computing Math.max(longest, difference)
            - if its more, move the left pointer by one and reduce frequency of char at left by one
        */

        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int longest = 0;
        int maxFreq = 0;

        while(right < s.length()) {
            char currentChar = s.charAt(right);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(currentChar));

            if((right - left) + 1 - maxFreq > k) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                left++;
            } else {
                longest = Math.max(longest, right - left + 1);
                
            }      

            right++;     
        }

        return longest;
        
    }
}
