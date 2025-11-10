class Solution {
    private static final int[] NROW = {0, -1, 0 , 1};
    private static final int[] NCOL = {-1, 0, 1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // no changes if starting pixel is the same as color
        int ogColor = image[sr][sc];
        if (ogColor == color) return image;
        
        // dimension of input matrix
        int m = image.length;
        int n = image[0].length;

        // run BFS to process qualifying neighbors
        bfs(image, sr, sc, m, n, ogColor, color);     
        return image;
    }


    /**
    Helper function for BFS: neighbors that have the same color as starting pixel
    will be processed into queue */
    private void bfs(int[][] image, int sr, int sc, int rowDim, int colDim, int ogColor, int color) {
        Queue<int[]> queue = new LinkedList<>(); // neighbors that have same color as starting pixel and need to be changed

        // add starting pixel queue
        queue.add(new int[] {sr,sc});

        // process the queue to find qualifying neighbors
        while (!queue.isEmpty()) {
            int[] currentPixel = queue.poll();
            int row = currentPixel[0];
            int col = currentPixel[1];
            image[row][col] = color; // change the color of pixel in queue

            // check its neighbor
            for (int i = 0; i < 4; i ++) {
                int curRow = row + NROW[i];
                int curCol = col + NCOL[i];

                // only process in-bound and not visited pixels
                // only visit ones that have the original color
                if (isValidPixel(curRow, curCol, rowDim, colDim) && image[curRow][curCol] == ogColor) {
                    image[curRow][curCol] = color; // if visited, change color
                    queue.add(new int[] {curRow,curCol}); // pixels added to queue only when they have the same color as the starting pixel
                }
            }
        }
    }

    /**
    Helper function to check if pixel is in bound */
    public static boolean isValidPixel(int row, int col, int row_bound, int col_bound) {
        return (row >= 0 && row < row_bound && col >= 0 && col < col_bound);
    }
}
// From the starting pixel, run BFS to find its neighbors (shares same sides) - in queue
// For each neighbor:
//  - dequeue to a visited set
//  -  if it has the same color as the starting pixel, change color and add its UNIVISTED neighbors to queue. else just dequeue