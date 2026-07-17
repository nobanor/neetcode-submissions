class Solution {
    public boolean isPalindrome(String s) {

        boolean isPalindrome = true;

        if(s.length() == 0) {
            return isPalindrome;
        }

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {

            //Move if special characters or spaces
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }


            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        return isPalindrome;
        
    }
}
