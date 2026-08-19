class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramsMap = new HashMap<>();

        for(String s : strs) {
            int[] count = new int[26];

            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            anagramsMap.putIfAbsent(key, new ArrayList<>());
            anagramsMap.get(key).add(s);
        }

        return new ArrayList<>(anagramsMap.values());   
    }
}
