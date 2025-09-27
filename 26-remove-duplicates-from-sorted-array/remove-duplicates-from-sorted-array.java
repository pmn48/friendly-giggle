class Solution { // change the element in place
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 1) return 1;
        int k = 1;
        
        for (int i = 1; i < len; i++) {
            if (nums[i-1] != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}