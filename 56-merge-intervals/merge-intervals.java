class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1 || intervals == null) return intervals;
        
        // sort all elements by start time (O(n))
        Arrays.sort(intervals, (a , b) -> Integer.compare(a[0], b[0]));

        // create an array to hold the merged intervals
        List<int[]> res_list = new ArrayList<>();

        // keep track of the current element in interval, update if needed and add to res
        int[] cur = intervals[0];
        int int_index = 1;
        while (int_index < intervals.length) {
            // if end time of cur >= start time of element in interval,
            // update cur to be the merged interval
            if (cur[1] >= intervals[int_index][0]) {
                cur[1] = Math.max(cur[1], intervals[int_index][1]); // new end time
                // do not add cur yet until it is checked against the next interval
            } else { // else, there is no overlap so add cur to list before updating to cur
                res_list.add(cur);
                cur = intervals[int_index];   
            }
            int_index++;
        }

        //System.out.println(cur[0] + " , " + cur[1]);

        // the final current element in the array
        res_list.add(cur);

        return res_list.toArray(new int[res_list.size()][]);
    }

}