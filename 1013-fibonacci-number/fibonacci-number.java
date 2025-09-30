class Solution { 
    public int fib(int n) { // Tabulation: bottom-up
        int[] dp = new int[2]; // a table to hold the values of lower numbers
        dp[0] = 0;
        dp[1] = 1;
        int result = 0;
        if (n <= 1) return dp[n];
        for (int i = 0; i < n; i++) {
            result = dp[0] + dp[1]; // latter = sum of the previous 2 numbers in fibonacci sequence
            dp[1] = dp[0]; 
            dp[0] = result;

            // 0 1 | 2 3 | 4 5 | 6 - index
            // 0 1 | 1 2 | 3 5 | 8 - f sequence
            // can see that new number = old result + dp[0]
        }
        return result; 
    }
    /* First solution: Recursion O(2^n)
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
    */
}