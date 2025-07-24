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
    public int getDecimalValue(ListNode head) {
        int result = 0;
        int len = 0;
        ListNode first = head;

        while (first != null) {
            len++;
            first = first.next;
        } 

        len -= 1;

        while (head != null) {
            result += (head.val * Math.pow(2, len));
            head = head.next;
            len--;
        }

        return result;
    }
}