public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA != null) ? pA.next : headB;
            pB = (pB != null) ? pB.next : headA;
        }

        return pA; // hoặc pB, vì nếu trùng thì cả hai bằng nhau
    }
}
