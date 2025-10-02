/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructBinary(nums, 0, nums.length - 1);
    }

    private TreeNode constructBinary(int[] nums, int lo, int hi) {
        // Base Case
        if (lo > hi) return null; // empty

         // find index of max value in input array
        int ptr = findMax(nums, lo, hi);
        System.out.println(ptr);
        // construct a root node with the max value 
        TreeNode root = new TreeNode(nums[ptr]);

        // prefix is 0 to ptr-1, suffix is ptr+1 to nums.length - 1
        root.left = constructBinary(nums, lo, ptr - 1);
        root.right = constructBinary(nums, ptr + 1, hi);

        return root;
    }

    /* find index of max value in input array
    have to indicate the range for the subarray, or else will have stackover flow error
    because of using the original nums (index will always stay as the first max ind in the og array)
    */
    private int findMax(int[] nums, int lo, int hi) {
        int ptr = lo;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > nums[ptr]) {
                ptr = i;
            }
            
        }
        return ptr;
    }
         
}