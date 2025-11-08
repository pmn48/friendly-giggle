class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return len;
        Map<Character, Integer> letterTable = new HashMap<>();
        int oddNumOfLetter = 0; // keep track of # of odd letters in s

        // loop through each char to update frequency
        for (char c: s.toCharArray()) {
            // 
            int count = letterTable.getOrDefault(c, 0) + 1;
            letterTable.put(c, count);

            // update the # of odd letter
            if (count%2 == 0) {
                oddNumOfLetter--;
            } else {
                oddNumOfLetter++;
            }
        }


        // return the longest length for palindrome
        if (oddNumOfLetter > 0) { // there is letter(s) with odd occurence, so one of the odd is excluded 
            return len - oddNumOfLetter + 1;
        }
        return len;
    }
}

// Greedy Algo: hash table / array to keep track how many times each letter appear
// to form a palindrome: the letters must have EVEN occurrence. for ODD ones, one can be used as the CENTER.
// the length of the longest palindrome: total length - count of characters with odd frequenciesn + 1 only unpaired character for the center if one exists (if there are 2 unpaired chars, )