class Solution {

    /**Helper function to check if the substring is still a palindrome */
    public boolean isPalindrome(String s, int left, int right) {
        // inspect s from 2 ends until another mismatch
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
       
        return true;
    } 
    
    
    public boolean validPalindrome(String s) {
        int right = s.length() - 1;
        if (right == 0) return true;
        int left = 0;
        
        while (left < right) {

            // at the first mismatch, skip it from both sides and check the rest of s to see if it is still valid
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        
        return true; 
    }
}

// input string has letters arranged so that it can be a palindrome after deleting at most 1 char from it
// therefore use 2 pointers and allow at most 1 mismatch