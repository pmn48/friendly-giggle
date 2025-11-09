class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> myStack = new Stack<>();

        for (char charInNum: num.toCharArray()) {
           
            // keep removing the top number if it is greater than the current number in num
            while (!myStack.empty() && myStack.peek() > charInNum && k > 0) {
                myStack.pop();
                k--;
            }

            // push the current number in num on stack
            myStack.push(charInNum);
        }

        // check if k > 0
        while (k > 0 && !myStack.empty()) {
            myStack.pop();
            k--;
        }

        // convert stack to a string
        String resStr = stackToStr(myStack);

        // edge case when all nums are removed
        if (resStr.length() == 0) return "0";

        return resStr;
    }

    /** Helper function to convert stack of char to string
     */
     public static String stackToStr(Stack<Character> myStack) {
        StringBuilder strB = new StringBuilder();

        while (!myStack.empty()) {
            char charNum = myStack.pop();
            strB.append(charNum);
        }

        // reverse string to get final answer
        strB.reverse();

        // convert to string
        String resStr = strB.toString();

        // get rid of leading 0
        int i = 0;
        while (resStr.length() > i && resStr.charAt(i) == '0') {
            i++;
        }

        return resStr.substring(i);
    }
}

// Utilize a monotonic stack to keep the numbers in order while iterating the num string:
    // - push the number on to the stack
    // - if the next number is greater than the top number in stack, keep pushing
    // - else, pop the top number and replace it with this new number
    // the max we can replace is k?
    // convert stack to string. trim any leading 0. if string is empty, return '0'.