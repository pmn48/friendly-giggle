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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        ListNode current = list; // start at the head
        if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        } 
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2; // link the next node to list2 node
                list2 = list2.next;
            } else {
                current.next = list1; // link the next node to list1 node
                list1 = list1.next;
            }
            current = current.next; // move on to prepare
        }

        if (list1 != null) {
            current.next = list1; // attach the rest of list 1 to current.next
        }

        if (list2 != null) {
            current.next = list2; // attach the rest of list 2 to current.next
        }

        return list.next;

    }

    // General Idea: Iterate both linkedlist, using their pointers. If node 1 >= node 2, add node 1 to final list, and move ptr1 forward. Do the same for node 2 > node 1.
    // Use a temp pointer to traverse the final list
}