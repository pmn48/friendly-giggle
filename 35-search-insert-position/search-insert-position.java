class Solution { // BINARY SEARCH ALGO
    public int searchInsert(int[] nums, int target) {

        // initial call
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {

        // invalid case: this is when target is greater than all elements in nums, pushing mid up
        // to the point where (mid + 1) > hi
        // OR smaller than all elements in nums, pushing mid down to the point where lo > (mid - 1)
        if (lo > hi) return lo; 

        int mid = (lo + hi)/2;

        if (target == nums[mid]) return mid;
        
        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, hi);
        }
        else { // (target < nums[mid])
            return binarySearch(nums, target, lo, mid - 1);
        }
        
    }

    // O(log n): operation that divides the input by a constant factor (2). 
    // In each iteration, it is an O(1) operation
    // Dividing the input arrays into half, left and right by mid = (lo + hi) / 2 until A[mid] = target
    // left array: everything smaller than target (lo to mid - 1)
    // right right: everything that greater than target (mid + 1 to hi)
    // if target in array: it will nums[mid]
    // else: insert it to the position after mid 
}