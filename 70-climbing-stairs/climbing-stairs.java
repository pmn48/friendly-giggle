class Solution { // Memoization

    static int[] stepTable = new int[50]; // during initialization, the array is filled with 0

    public int climbStairs(int n) {
        // base case
        if (n <= 2) return n;

        if (stepTable[n] == 0) {
            //if the value is already computed, it is stored in this table so just retrieve it
            // else, store the result into the table then return it
            stepTable[n] = climbStairs(n-1) + climbStairs(n-2);
        }
        return stepTable[n];
        
    }

    /*public static int CalComb(int n, int count) {
        if (count > n) return 0;
        if (count == n) return 1;
        int res = 1;
        //count = Math.min(count, n - count); //C(n-r) = Cr
        for (int i = 0; i < count; i++) {
            res *= (n - i);
            res /= (i+1);
        }
        return res;
    }*/

    //return climbStairs(n - 1) + climbStairs(n - 2);
        /*int res = 1;
        int dif = 0, count = 0;
        for (int i = n; i > 1; i -= 2) {
            System.out.println(i);
            System.out.println(res);
            count++; // this is the number of 2 in the sum
            System.out.println(count);
            // find nCcount to count the solutions of where to place the number 2(s)
            dif = n - count*2;
            int sum = count + dif;
            res = res +  CalComb(sum, count);
            System.out.println(dif);
            System.out.println(res);
        }
        return res;*/
}