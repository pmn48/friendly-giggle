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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        int[] nodeVal = new int[5001];
        int i = 0;

        //traverse until reach tail
        while (temp != null) {
            nodeVal[i] = temp.val;
            System.out.println(nodeVal[i]);
            System.out.println(i);
            temp = temp.next;
            i++; // in the last iteration, i moves to a null value
        }

        // decrease i to the last element in array first
        i--;

        ListNode current = head;
        // update the value of each node by using the array
        while (current != null) {
            while (i >= 0) {
                //System.out.println(nodeVal[i]);
                current.val = nodeVal[i];
                current = current.next;
                i--;
            }
        }

        return head;
    }
}