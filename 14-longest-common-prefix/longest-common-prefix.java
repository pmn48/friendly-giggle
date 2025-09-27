class Solution { // Divide-and-Conquer
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefixRecurse(strs, 0, strs.length-1);
    }

    private String longestCommonPrefixRecurse(String[] strs, int start, int stop) { // Divide the list of strings into 2 halfs
        if (start == stop) return strs[start];
        int mid = (start + stop)/2;
        String left = longestCommonPrefixRecurse(strs, start, mid);
        String right = longestCommonPrefixRecurse(strs, mid+1, stop);
        return CombineCommonPrefix(left, right); // after having the common prefix for each pair, start comparing them
    }

    private String CombineCommonPrefix(String left, String right) { // compare the prefix between two prefixes
        int llen = left.length();
        int rlen = right.length();
        if (llen == 0 || rlen == 0) return "";
        String prefix;
        if (llen <= rlen) {
            prefix = left;
        } else {
            prefix = right;
        }

        for (int i = 0; i < prefix.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) return prefix.substring(0,i);
        }
        return prefix;
    }
}