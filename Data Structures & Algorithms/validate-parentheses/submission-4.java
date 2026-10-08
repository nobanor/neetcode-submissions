class Solution {
    public boolean isValid(String s) {


        Map<Character, Character> bracketsMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');

        for(char c : s.toCharArray()) {
            if(bracketsMap.get(c) != null) {
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
