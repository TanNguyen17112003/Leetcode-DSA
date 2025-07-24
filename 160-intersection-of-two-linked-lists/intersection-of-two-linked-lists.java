/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode firstA = headA, firstB = headB;
        while (firstA != null) {
            while (firstB != null) {
                if (firstA == firstB) return firstA;
                firstB = firstB.next;
            }
            firstB = headB;
            firstA = firstA.next;
        }
        return null;
    }
}