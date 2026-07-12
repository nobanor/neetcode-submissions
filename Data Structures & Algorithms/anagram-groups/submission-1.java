class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for(String str : strs) {
            int[] count = new int[26];

            for(char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            anagramsMap.putIfAbsent(key, new ArrayList<>());
            anagramsMap.get(key).add(str);
        }
        
        return new ArrayList<>(anagramsMap.values());
    }
}
