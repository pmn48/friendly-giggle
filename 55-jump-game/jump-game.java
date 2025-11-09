class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int target = len - 1;
        
        // the max one can jump is nums[i]. so if from i and nums[i] steps, one can reach the target, walk back to that i and see if the next one can do the same
        for (int i = len - 1; i >= 0; i--) {            
            if (i + nums[i] >= target) {
                target = i;
            }
        }

        if (target != 0) return false;
        return true;
    }
}

// Greedy Algo: START FROM THE BACK. after taking nums[i] step from current index if can reach target: Update target;
// by the time nums[0] is reached and target > 0, return false
// otherwise true