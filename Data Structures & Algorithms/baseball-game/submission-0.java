class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for(String s : operations) {

            if(s.equals("C")) {
                stack.pop();
            } else if(s.equals("D")) {
                int prev = stack.peek();
                stack.push(prev * 2);
            } else if(s.equals("+")) {
                int numA = stack.pop();
                int numB = stack.pop();
                int sum = numA + numB;
                stack.push(numB);
                stack.push(numA);
                stack.push(sum);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        int result = 0;

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}