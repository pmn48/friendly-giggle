class Solution {
    public String addBinary(String a, String b) {
        int alen = a.length() - 1;
        int blen = b.length() - 1;

        int carry = 0;
        int raw, result;
        StringBuilder sb = new StringBuilder();
        while (alen >= 0 && blen >= 0) {
            //convert char to int
            int a_int = a.charAt(alen) - '0';
            int b_int = b.charAt(blen) - '0';

            // calculate raw result
            raw = a_int + b_int + carry;
            
            // convert to binary result and generate carry
            if (raw <= 1) {
                result = raw;
                carry = 0;
            } else {
                if (raw == 2) { // 1 + 1 + 0
                    result = 0;
                } else { // 1 + 1 + 1
                    result = 1;
                }
                carry = 1;
            }

            // append binary result into sb
            char charResult = (char) (result + '0');
            sb.append(charResult);

            alen--;
            blen--;
        }

        while (alen >= 0) {
            //convert char to int
            int a_int = a.charAt(alen) - '0';

            // calculate raw result
            raw = a_int + carry;

            // convert to binary result and generate carry
            if (raw <= 1) {
                result = raw;
                carry = 0;
            } else { // can only be 1 + 1
                result = 0;
                carry = 1;
            }

            // append binary result into sb
            char charResult = (char) (result + '0');
            sb.append(charResult);

            alen--;
        }

        while (blen >= 0) {
            //convert char to int
            int b_int = b.charAt(blen) - '0';

            // calculate raw result
            raw = b_int + carry;

            // convert to binary result and generate carry
            if (raw <= 1) {
                result = raw;
                carry = 0;
            } else { // can only be 1 + 1
                result = 0;
                carry = 1;
            }

            // append binary result into sb
            char charResult = (char) (result + '0');
            sb.append(charResult);

            blen--;
        }

        if (carry > 0) {
            // append binary result into sb
            char charResult = (char) (carry + '0');
            sb.append(charResult);
        }

        // reverse the string
        String finalResult = reverseString(sb);

        return finalResult;
    }

    private String reverseString(StringBuilder sb) {
        StringBuilder reverseSb = sb.reverse();
        String result = reverseSb.toString();
        return result;
    } 

    // Iterate through each char of a and b, from the right:
    // - convert char to int
    // - Get the raw result = a[i] + b[i] + carry
            // - if raw > 1: result = 0 (raw = 2)  OR result = 1 (raw = 3), carry = 1
            // else: result = raw, carry = 0
    // continue iterating thu a or b until done, for calculation
    // at the end, if  carry = 1, append to the list
    // reverse the list to get answer
}