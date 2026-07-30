class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(']', '[');
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');

        for(char c : s.toCharArray()) {

            if(bracketsMap.containsKey(c)){
                if(stack.isEmpty() || bracketsMap.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
