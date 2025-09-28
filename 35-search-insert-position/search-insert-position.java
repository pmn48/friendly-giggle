class Solution { // BINARY SEARCH ALGO
    public int searchInsert(int[] nums, int target) {

        // initial call
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {

        // invalid case: this is when target is greater than all elements in num, pushing mid up
        // to the point where mid will be greater than hi
        // append target to the end index, at this point is high
        if (lo > hi) return lo; 

        // this is when the target is smaller than all elements in num, pushing mid equal to lo
        if (lo == hi) {
            if (target <= nums[hi]) return hi;
            else if (target > nums[hi]) return hi + 1; 
            // everything to the left should be smaller than target
        }

        int mid = (lo + hi)/2;

        if (target == nums[mid]) return mid;
        
        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, hi);
        }
        else { // (target < nums[mid])
            return binarySearch(nums, target, lo, mid);
        }
        
    }

    // O(log n): operation that divides the input by a constant factor (2). 
    // In each iteration, it is an O(1) operation
    // Dividing the input arrays into half, left and right by mid = (lo + hi) / 2 until A[mid] = target
    // left array: everything smaller or equal to target (lo to mid)
    // right right: everything that greater than target (mid + 1 to hi)
    // if target in array: it will be either the last one in left (mid)
    // else: insert it to the position after mid 
}