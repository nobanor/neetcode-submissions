class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        /*
        - Make two pointers left and right
        - Expand window and keep track of unique characters in the set
        - Once you get to duplicate character, move left until current character is removed
        */

        Set<Character> seen = new HashSet<>();
        int left = 0;
        int right = 0;
        int longest = 0;

        while(right < s.length()) {
            while(seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left++));
            }

            seen.add(s.charAt(right));
            longest = Math.max(longest, seen.size());
            right++;
        }

        return longest;
    }
}
