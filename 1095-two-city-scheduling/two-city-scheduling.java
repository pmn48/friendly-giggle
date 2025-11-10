class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Build a min heap for delta cost and person
        Queue<int[]> deltaMinHeap = buildDeltaHeap(costs);

        // examine which person can switch to city B so that delta is minimized
        int len = costs.length;
        int n = 1; // minimum for n

        // calculate the initial total cost where 2n persons fly to city A
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += costs[i][0];
        }
        
        // update total cost by adding delta, until n persons switch to B
        while (n <= len/2) {
            int[] personDelta = deltaMinHeap.poll();  // pop the one with minimum delta
            res += personDelta[0];
            n++;
        }
        return res;
    }

    /**
    Helper function to build a Min heap of delta for each person */
    public static Queue<int[]> buildDeltaHeap(int[][] costs) {
        int len = costs.length;

        Queue<int[]> deltaMinHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0])); // [ [delta, person]]

        for (int i = 0; i < len; i++) {
            int[] cost = costs[i];
            int dif = cost[1] - cost[0];
            deltaMinHeap.add(new int[] {dif, i});
        }
        return deltaMinHeap;     
    }
}


// total cost Q = a + b, with a > n currently
// have to satisfy the restriction that a = b = n, so has to flip (a - n)
// cost to flip each city delta = (city B - city A)
// total cost is Q + delta -> minimize delta so that Q is minimized
// Greedy Algorithm: Assign all 2n person to city A, then switch n persons to city B. Choose person to switch based on minimum delta -> min heap and visited set