class Solution { // Dynamic Programming
    public int numSquares(int n) {
        int[] dp = new int[n+1]; // can hold up to dp[n] element
        Arrays.fill(dp, 1, n+1, Integer.MAX_VALUE); // fill dp[1] and beyond with inf. keep dp[0] = 0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1); // keep checking the current val with the new val to find the minimum
            }
        }

        return dp[n];   
    }

    /**
    Finding subproblem: dp[i] = dp[j] + 1 (j <= i)
    for eg: dp[12] = dp[8] + 1 / dp[11] + 1 / dp[3] + 1
    - Have an array to store the min num of perfect squares that can sum up to input n
    - dp[i] indicates the min # of perfect squares that can sum up to i
    - dp[i] = min(dp[i - j*j] + 1) - all possible solutions that can make up i, from j = 1 to j = sqrt(i) -> find min at each iteration
    - return dp[i], which is min
     */
}