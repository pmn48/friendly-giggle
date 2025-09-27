class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int dif;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            dif = target -  nums[i];
            if (myMap.containsKey(nums[i])) {
                res[0] = myMap.get(nums[i]);
                res[1] = i;
                return res;
            } else {
                myMap.put(dif, i);
            }
        }
        return res;
    }
}