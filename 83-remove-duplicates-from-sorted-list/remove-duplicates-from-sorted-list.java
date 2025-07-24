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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, next = head.next;

        while (cur != null && next != null) {
            if (cur.val == next.val) {
                next = next.next;
                cur.next = next;
            }
            else {
                cur = next;
                next = next.next;
            }
        }

        return head;
    }
}