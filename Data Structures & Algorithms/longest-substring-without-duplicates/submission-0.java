class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> uniqueCharacters = new HashSet<>();
        int longest = 0;

        int left = 0;
        int right = 0;

        while(right < s.length()) {
            while(uniqueCharacters.contains(s.charAt(right))) {
                uniqueCharacters.remove(s.charAt(left));
                left++;
            } 

            uniqueCharacters.add(s.charAt(right));
            right++;
            longest = Math.max(longest, right - left);
        }

        return longest;
    }
}
