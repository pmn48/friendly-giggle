class Solution {

    public void myQuickSort(int[][] points, int lo, int hi) {
        if (lo < hi) {
            int pivotInd = myPartition(points, lo, hi);
            myQuickSort(points, lo, pivotInd - 1);
            myQuickSort(points, pivotInd + 1, hi);
        }
    }

    public int myPartition(int[][] points, int lo, int hi) {
        // choose the pivot as the last element
        int pivotDist = points[hi][0] * points[hi][0] + points[hi][1] * points[hi][1];

        // index to keep track of all element that are smaller than pivot
        int smaller = lo - 1;

        // move the smaller up after swapping
        for (int i = lo; i < hi; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pivotDist) {
                smaller++;
                swap(points, smaller, i);
            }
        }

        // swap the pivot to the position after smaller
        swap(points, smaller + 1, hi);

        return smaller + 1; // index of pivot
    }

    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
        
    }



    public int[][] kClosest(int[][] points, int k) {

        int len = points.length;
        myQuickSort(points, 0, len -1);

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }

        return res;
    }
}

//Approach 1: sort the points based on distance (ascending), then return the first k elements
// Approach 2: quickselect(i) up to k, add elements into a res array
// Approach 3: use min-heap of size k

