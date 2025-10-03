class Solution {

    public int[] sortedSquares(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = temp * temp;
        }

        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[right + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[left] > nums[right]) {
                res[i] = nums[left];
                left++;
            } else {
                res[i] = nums[right];
                right--;
            }
            
        }

        return res;

        
    }

}
    // approach 1: squares in place, then use mergesort (O(n) + O(nlog n)
    // approach 2: squares in place, then 2 pointers O(n)