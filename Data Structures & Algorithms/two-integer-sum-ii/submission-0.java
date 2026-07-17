class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int leftNum = numbers[left];
            int rightNum = numbers[right];
            int sum = leftNum + rightNum;

            if(sum > target) {
                right--;
            }else if(sum < target) {
                left++;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }

        return result;
        
    }
}
