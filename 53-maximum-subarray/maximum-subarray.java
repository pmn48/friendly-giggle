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


    /*// DIVIDE AND CONQUER
    public int maxSubArray(int[] nums) {
        return maxSubArrayRecurse(nums, 0, nums.length - 1);
    }

    private int maxSubArrayRecurse(int[] nums, int lo, int hi) {
    // Base Case
    if (lo == hi) return nums[lo]; // 1 element

        int mid = lo + (hi - lo) / 2;
        int left = maxSubArrayRecurse(nums, lo, mid);
        int right = maxSubArrayRecurse(nums, mid + 1, hi);

        // Find sum of the Subarray that crosses the mid point
        int midpoint = maxMidPoint(nums, lo, mid, hi);

        // return the max sum among the calculated value
        return Math.max(Math.max(left, right), midpoint);

    }

    private int maxMidPoint(int[] nums, int lo, int mid, int hi) {
        
        // find the max on the left half
        int current = nums[mid];
        int leftMax = nums[mid]; 
        for (int i = mid; i >= lo; i--) {
            leftMax = Math.max(leftMax + nums[i], nums[i]);
            current = Math.max(current, leftMax);
        }

        // find the max on the right half
        int rightMax = nums[mid + 1]; 
        current = nums[mid + 1];
        for (int i = mid + 1; i <= hi; i++) {
            rightMax = Math.max(rightMax + nums[i], nums[i]);
            current = Math.max(current, rightMax);
        }

        // The maximum crossing sum is the sum of the best left and right parts.
        return leftMax + rightMax;
    }*/  
}

