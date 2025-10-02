class Solution { 
    // MergeSort
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        return myMergeSort(nums, 0, nums.length - 1);
    }

    /**A helper function for MergeSort: choosing a pivot, keep dividing the array into subarrays to sort, then merge the sorted arrays */
    private int[] myMergeSort(int[] nums, int lo, int hi) {
        // Base Case: one element left, which is when the lo and hi are equal
        if (lo >= hi) {
            int[] res = new int[1];
            res[0] = nums[lo];
            return res;
        }

        // Divide the array
        int mid = lo + (hi - lo) / 2;
        int[] left = myMergeSort(nums, lo, mid);
        int[] right = myMergeSort(nums, mid+1, hi);

        // Combining the left and right sorted arrays
        return myMergeCombine(left, right);
    }

    /** A helper function to merge 2 sorted arrays
     */
     private int[] myMergeCombine(int[] left,int[] right) {

        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[k++] = left[i++];
            } else {
                res[k++] = right[j++];
            }
        }

        while (i < left.length) {
            res[k++] = left[i++];
        }

        while (j < right.length) {
            res[k++] = right[j++];
        }

        return res;
     }
    
    /*// QuickSort
    public int[] sortArray(int[] nums) {
        myQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void myQuickSort(int[] nums, int lo, int hi) {
        if (lo >= hi || nums.length == 0) return;

        int pivot = myPartition(nums, lo, hi); // pivot index
        myQuickSort(nums, lo, pivot - 1);
        myQuickSort(nums, pivot + 1, hi);
    }

    /** A helper function to partition the arrays into left and right half
    - everything on the left of pivot will be less than nums[pivot], else on the right
    - return the pivot index
     */
     /*
    private int myPartition(int[] nums, int lo, int hi) {
        // choose a random pivot - median
        int pivot = nums[lo + (hi-lo)/2]; 
        // initialize 2 cursors to traverse from left and right of nums
        int left_arr = lo;
        int right_arr = hi;
        int current = lo;

        while (current < right_arr + 1) { // until current and right ptr meet
            int temp = nums[current];
            if (temp < pivot) { // if smaller, swap the number with the one on the left array
            //Since everything on the left has current go thru already, it is safe to move both pointers forward
                nums[current] = nums[left_arr];
                nums[left_arr] = temp;
                current++;
                left_arr++;
            } else if (temp > pivot) {
// if greater, swap current to the right
// since the number on the right has not been inspected yet, current ptr does not move forward - waiting to be inspected
// only move right ptr back
                nums[current] = nums[right_arr];
                nums[right_arr] = temp;
                right_arr--;
            } else { // if equal, skip the number
                current++;
            }
        }

        return left_arr; // return index of the pivot
    }*/
}