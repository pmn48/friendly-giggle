class Solution {
    public List<List<Integer>> threeSum(int[] nums) { 

       // sort the array first 0(nlogn)
       Arrays.sort(nums);

       List<List<Integer>> res = new ArrayList<>();
       
       for (int i = 0; i <= nums.length - 2; i++) { // only go up to that since have 2 more ptrs = account for left and right
            // skip duplicate of nums[i]
                if (i > 0 && nums[i] == nums[i-1]) continue; // nums[i-1] must be checked already

            // reset for every element
            int left = i+1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) { // the one on right is too big
                    right--;
                } else if (sum < 0) { // the on on the left is too negative
                    left++;
                } else {
                    List<Integer> temp = createTempList(nums, left, i, right);
                    res.add(temp);
                    left++;
                    right--;

                    // if nums[left] or nums[right] have duplicates, keep changing them
                    while (right > left && nums[left] == nums[left-1]) left++; // check from left
                    while (right > left && nums[right] == nums[right+1]) right--; // check from right
                }
            }    
       }
       return res;
    }

    /**A helper function to add elements from an array to a list */
    public List<Integer> createTempList(int[] nums, int i, int j, int k) {
        List<Integer> res = new ArrayList<>();
            res.add(nums[i]);
            res.add(nums[j]);
            res.add(nums[k]);
        // sort the array in ascending order so that duplicates can be identified
        //Collections.sort(res);
        return res;
    }

    
}

// a + b + c = 0 -> c = -(a + b)
// BRUTE FORCE: passed 314/315 cases. O(n^2)
/*class Solution {
    public List<List<Integer>> threeSum(int[] nums) { 
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) { // O(n)
            myMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i); // if key is not in map yet, when putting it in, create an empty list as value, then add to list
        }

        Set <List<Integer>> mySet = new HashSet<>();
        for (int i = 0; i < len; i++) { // O(n^2)
            for (int j = 0; j < len; j++) {
                if (j == i) continue;
                int sum2 = nums[i] + nums[j];
                int num = sum2 * (-1);
                if (myMap.containsKey(num)) {
                    List<Integer> ind_List = myMap.get(num);

                    // loop through each index of the element
                    for (int ind: ind_List) {
                        if (ind != i && ind != j) { // will skip if it is the same element
                            List<Integer> temp = createTempList(nums, i, j, ind);
                            mySet.add(temp); 
                            
                            break; // once the list is set, ignore other indices as it will be duplicates
                        }
                    }    
                }
            }
        }
        return new ArrayList<>(mySet);
    }

    public List<Integer> createTempList(int[] nums, int i, int j, int k) {
        List<Integer> res = new ArrayList<>();
        if (i <= (nums.length - 1) && j <= (nums.length - 1) && k <= (nums.length - 1)) {
            res.add(nums[i]);
            res.add(nums[j]);
            res.add(nums[k]);
        }
        // sort the array in ascending order
        Collections.sort(res);
        return res;
    }
    
}*

 */



