class Solution {
    public boolean isAnagram(String s, String t) {


        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCharCountMap = new HashMap<>();
        Map<Character, Integer> tCharCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sCharCountMap.put(s.charAt(i), sCharCountMap.getOrDefault(s.charAt(i), 0) + 1);
            tCharCountMap.put(t.charAt(i), tCharCountMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        
        //Loop through map or string?

        for(char c : s.toCharArray()) {

            if(!sCharCountMap.get(c).equals(tCharCountMap.get(c))) {
                return false;
            }
        }

        return true;
        


    }
}
