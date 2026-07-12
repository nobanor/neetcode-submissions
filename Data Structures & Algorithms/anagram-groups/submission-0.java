class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //Empty result list of list
        //Go through strs
        //Store sorted str and actual strs in a map. 
        //For each key in a map, return all values 

        List<List<String>> anagrams = new ArrayList<>(); 
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for(String str : strs) {

            String sortedStr = sort(str);

            if(anagramsMap.containsKey(sortedStr)) {
                anagramsMap.get(sortedStr).add(str);
            } else {
                anagramsMap.put(sortedStr, new ArrayList(Arrays.asList(str)));
            }
        }

        for(String key : anagramsMap.keySet()) {
            anagrams.add(anagramsMap.get(key));
        }

        return anagrams; 
    }

    private String sort(String str) {

        char [] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String sortedStr = new String(charArray); 

        return sortedStr;
    }
}
