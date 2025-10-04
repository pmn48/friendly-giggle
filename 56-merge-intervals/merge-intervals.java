class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1 || intervals == null) return intervals;
        
        // sort all elements by start time (O(n))
        Arrays.sort(intervals, (a , b) -> Integer.compare(a[0], b[0]));

        // keep track of the current element in interval at merge_index
        int int_index = 1;
        int merge_index = 0;
        while (int_index < intervals.length) {
            // if end time of cur >= start time of element in interval
            if (intervals[merge_index][1] >= intervals[int_index][0]) {
                intervals[merge_index][1] = Math.max(intervals[merge_index][1], intervals[int_index][1]);
            } else { //there is no overlap 
                merge_index++; // move forward and copy to next
                intervals[merge_index] = intervals[int_index];

            }
            int_index++;
        }

        // only until the updated interval
        return Arrays.copyOfRange(intervals, 0, merge_index + 1);
    }

}

// Separate array
/*
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
            } else { //there is no overlap so add cur to list before updating to cur

                res_list.add(cur);
                cur = intervals[int_index];   
            }
            int_index++;
        }

        //System.out.println(cur[0] + " , " + cur[1]);

        // the final current element in the array
        res_list.add(cur);

        return res_list.toArray(new int[res_list.size()][]);
}*/