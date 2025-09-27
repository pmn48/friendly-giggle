/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode();
        ListNode current = list;
        int num, remainder;
        int digit = 0;
        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + digit;
            remainder = num%10;
            digit = num/10;
            current.next = new ListNode(remainder);
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }

        while (l1 != null) {
            num = l1.val +  digit;
            remainder = num%10;
            digit = num/10;
            current.next = new ListNode(remainder);
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            num = l2.val +  digit;
            remainder = num%10;
            digit = num/10;
            current.next = new ListNode(remainder);
            l2 = l2.next;
            current = current.next;
        }

        if (digit > 0) {current.next = new ListNode(digit);}

        return list.next;
    }
}