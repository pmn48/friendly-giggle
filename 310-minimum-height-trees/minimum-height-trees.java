class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<List<Integer>> adj = createAdjacentList(n, edges);

        Queue<Integer> leaves = new LinkedList<>();
        Map<Integer, Integer> edge_count = new HashMap<>();
        // go through the adj list. nodes with 1 edge (1 neighbor) is a leaf
        for (int i = 0; i < adj.size(); i++) {
            int neiCount = adj.get(i).size();
            if (neiCount == 1) {
                leaves.add(i);
            }
            edge_count.put(i, neiCount); // record the number of edges for each node
        }

        // go though the layers: from leaves and up
        // remove the leaves. Once the first layer is removed, add the next layer's leaves to queue
        // return until only 2 nodes left
        while (!leaves.isEmpty()) {
            if (n <= 2) return new ArrayList<>(leaves);

            int layerSize = leaves.size(); // Store the size *before* the loop
            for (int i = 0; i < layerSize; i++) { // layer of leaves
                int node = leaves.poll();
                n--;
                // iterate through the neighbors of each node
                for (Integer nei: adj.get(node)) {
                    // remove one edge of each neighbor as the node is removed
                    int new_neiCount = edge_count.get(nei) - 1;
                    // update edge count
                    edge_count.put(nei, new_neiCount);
                    // check if nei has become a leaf and add it to leaves queue
                    if (new_neiCount == 1) {leaves.add(nei);}
                }
            }
        }

        // default
        return new ArrayList<>(leaves);
    }

    /**
     */
    public static List<List<Integer>> createAdjacentList(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        // Fill the list with list of nodes
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // traverse edges array to make adj list
        for (int[] edge: edges) {
            int node_i = edge[0];
            int node_j = edge[1];
            // add neighbor for node i
            adj.get(node_i).add(node_j);
            // add neighbor for node j
            adj.get(node_j).add(node_i);
        }

        return adj;
    }
}
// identify the leaves: those with just one edge -> cannot be a root of MHT
// at most 2 roots for MHT
// Approach 1: run DFS twice to find the longest path from a leaf -> root for MHT is the middle node
// Approach 2: topological sort