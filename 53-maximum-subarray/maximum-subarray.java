class Solution {
    public int maxSubArray(int[] nums) { // 0(n)
        int n = nums.length;
        if (n == 1) return nums[0];

        // initialize the variables to hold sum
        int current = nums[0];
        int max = nums[0];

        // traverse the array
        // update current to see if it should start from another element, or keep adding to it
        // update max by taking the maximum between max and current
        for (int i = 1; i < n; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }

    /* O(n^2)
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            result = Math.max(result, sumSubArray(nums, i));
        }
        return result;
    }

    /**A helper function to calculate the max sum of a subarray of k elements 
    private static int sumSubArray(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return Integer.MAX_VALUE; // error case

        // calculate the sum of the first subarray with k elements
        int sum = 0;
        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }

        // calculate other sums of other subarrays while traversing down the array
        for (int i = 1; i <= (n - k); i++) {
            sum = Math.max(sum, sum - nums[i -1] + nums[i+k-1]);
        }
        return sum;
    }

    /** Sliding Window Approach: sum[start + 1, end + 1] = sum[start + end] - A[start] + A[end+1]
    k = number of elements in subarray. 1 <= k <= n? SO HAVE A HELPER FUNCTION TO INDICATE k  AS A VARIABLE
    MAIN FUNC: Have a for loop to iterate through k
        result = Max (result, sum - nums[i] + nums[k+1])

     */
}