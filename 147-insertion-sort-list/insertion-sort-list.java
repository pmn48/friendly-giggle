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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        ListNode res = new ListNode(); // an empty list for result
        while (current != null) {
            // start traversing prev at each iteration
            ListNode prev = res;

            // find the position to insert current into the result list (which shouold be between a smaller and larger value)
            // want to keep track of the smaller value node
            // loop stops when prev is at the node is BEFORE a node that has a value >= current.val
            while (prev.next != null && current.val >= prev.next.val) {
                prev = prev.next;
            }
            
            // keep track of the node that is next in the input list for iteration
            ListNode temp = current.next;

            // inserting current node into res list
            current.next = prev.next; // prev - cur - prev.next
            prev.next = current;

            // move current to the next node in the input list
            current = temp;

        }

        return res.next;
    }
}