class Solution {
    private static final int[] NROW = {0, -1, 0 , 1};
    private static final int[] NCOL = {-1, 0, 1, 0};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // queue to hold cells as [row, col, distance to 0]
        Queue<int[]> queue = new LinkedList<>();

        // add cell of 0 to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] {i, j, 0}); 
                } else {
                    mat[i][j] = Integer.MAX_VALUE; // non-zero cells
                }  
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int curRow = currentCell[0];
            int curCol = currentCell[1];
            int curDist = currentCell[2];

            // check immediate neighbors
            for (int i = 0; i < 4; i++) {
                int neiRow = curRow + NROW[i];
                int neiCol = curCol + NCOL[i];
                if (isValidCell(neiRow, neiCol, m, n) && mat[neiRow][neiCol] == Integer.MAX_VALUE) {
                    int neiDist = curDist + 1;
                    mat[neiRow][neiCol] = neiDist; // update the cell to become the distance to 0
                    queue.add(new int[] {neiRow, neiCol, neiDist}); 
                }
            }    
        }
        return mat;   
    }

     /** Helper function: check if the cell is within bound
     */
    public static boolean isValidCell(int curRow, int curCol, int m, int n) {
        return (curRow >= 0 && curRow < m && curCol >= 0 && curCol < n);
    }
}
   
// Apply BFS from 0 nodes to find the distance to non-zero ones (neighbors)
//  - Add all the 0 nodes to a queue. set their distance as 0. others can become INFINITY
//  - Dequeue current node. Examine its immediate neighbor. If not in queue: if the distance is INFINITY, update neighbor's distance = current distance + 1. Add that node to queue
// repeat until queue is empty