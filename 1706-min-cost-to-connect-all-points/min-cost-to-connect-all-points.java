class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        if (len <= 1) return 0; 
        // create adjacent list
        List<List<int[]>> adj = createWeightedAdjacencyList(points);

        // PRIM'S ALGO
        int res = 0;
        Set<Integer> visit = new HashSet<>();

        // min heap to fins the smallest distance
        // Provide a comparator that compares arrays based on their first element (distance)
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] {0,0});

        // update MST based on weight of edges
        while (visit.size() < len) {
            // pop the neighbor with minimum edge weight
            int[] minEdge = minHeap.poll(); 
            int weight = minEdge[0]; 
            int node = minEdge[1];

            if (visit.contains(node)) continue; // skip if the node is visited
            res += weight; // if not
            visit.add(node);

            // Iterate through the neighbors and Add to MST
            for (int[] neighborList: adj.get(node)) {
                int edgeCost = neighborList[0];
                int nei = neighborList[1];
                if (!visit.contains(nei)) {
                    minHeap.add(new int[] {edgeCost, nei});
                }
            }
        }

        return res;
    }


    /**Helper function to create an adjacency list for each node that shows its neighbors and the distance to each neighbor 
    adj = [ [[dist1, j1], [dist2, j2]], [[dist3, j3], [dist4, j4]]]
    */
    public static List<List<int[]>> createWeightedAdjacencyList(int[][] points) {
        int len = points.length;

        // initialize an ArrayList to hold the arrays
        List<List<int[]>> adj = new ArrayList<>();
        // fill adj with array list for each node
        for (int i = 0; i < len; i++) {
            adj.add(new ArrayList<>());
        }

        // for each node i in adj, put a list of [distance, neighbor j]
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) { // neighbor nodes
                // calculate manhattan distance
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                // put neighbor j for i
                int[] arr1 = new int[] {dist, j};
                adj.get(i).add(arr1);

                // put neighbor i for j?
                int[] arr2 = new int[] {dist, i};
                adj.get(j).add(arr2);
            }   
        }

        return adj;
    }
}

// Greedy Algo: for the manhattan distance to be minimized, choose the one with either closest x or closest y -> smallest edge value
// create all the edges
// Apply Prim's algo: choose a starting vetex.
    // Examine each vertex neighbors: choose one with minimum distance and add the neighbor to set of MST
    //until all points are moved to the final set
// O(n2 logn): n2 because have to create all edges for n points; log n comes from min heap