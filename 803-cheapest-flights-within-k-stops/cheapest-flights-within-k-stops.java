class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // create adjacency list that shows [ src1: [ {dest, price} ] ]
        List<List<int[]>> adj = createWeightedAdjacencyList(n, flights);
        
        // A queue for visiting
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {src,0}); // the price from source to itself
        // cost vector to keep track of minimum cost to reach node i
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        // number of stops
        int stop = 0;

        while (!queue.isEmpty() && stop <= k) {
            int currentLen = queue.size();
            for (int i = 0; i < currentLen; i++) {
                int[] curSrcArr = queue.poll();
                int curSrc = curSrcArr[0];
                int curPrice = curSrcArr[1];
                // iterate throught the source's dest and price
                for (int[] destination: adj.get(curSrc)) {
                    int dest = destination[0];
                    int price = destination[1];

                    // if new price is greater, dont choose to include this destination as a route, as another cheaper route to this destination is available
                    if (price + curPrice >= minCost[dest]) continue;
                    // if new price is smaller, choose this route and update the min cost to get to this dest in minCost array
                    minCost[dest] = price + curPrice;
                    queue.add(new int[] {dest, minCost[dest]});
                }
            }
            stop++;
        }
        //printAdjList(adj);
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    /**Helper function to create an adjacency list for each node that shows its neighbors and the distance to each neighbor 
    adj = [ [[dist1, j1], [dist2, j2]], [[dist3, j3], [dist4, j4]]]
    */
    public static List<List<int[]>> createWeightedAdjacencyList(int n, int[][] flights) {

        // initialize an ArrayList to hold the arrays
        List<List<int[]>> adj = new ArrayList<>();
        // fill adj with array list for each node
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // for each node in adj, put a list of [neighbor, price]
        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];
             // put dest for source
            int[] arr1 = new int[] {dest, price};
            adj.get(source).add(arr1);

        }
        return adj;
    }

    private static void printAdjList(List<List<int[]>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Neighbor of " + i + " and price is: ");
            for (int[] edge : adj.get(i)) {
                System.out.println(Arrays.toString(edge) + " ");
            }
        }
    }
}
// value cheaper price (edge weight) over shortest path (less edges) - apply BFS for finding shorest path and prim's for MST?
// visited queue: from src
// add neigbor to visited