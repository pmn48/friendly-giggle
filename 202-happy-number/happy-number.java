class Solution {

    public boolean isHappy(int n) {
        HashSet<Integer> nums = new HashSet<>(); // store unique computed number
        
        while (!nums.contains(n)) {
            nums.add(n);
            n = computeSum(n);
            if (n == 1) return true;
        }
        
        return false;
    }


    private static int computeSum(int n) {
        int output = 0;
        while (n != 0) {
            int remainder = n % 10;
            output += remainder * remainder;
            n = n / 10;
        }
        return output;
    }


}

// Main func: keep getting new output and checking it.
    // if output = 1: true. if not, save it to Set
    // if output is already in a Set nums, meaning in an infinite loop -> false
// Helper func: Use remainder to compute output n
    //
    // while res != 0:
        // remainder = res%10
        // output += remainder*remainder
        // res = res/10
    //
    // output += 9*9 = 81
