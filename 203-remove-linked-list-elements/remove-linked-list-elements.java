class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElements(head.next, val); // xử lý phần còn lại

        return head.val == val ? head.next : head; // quyết định giữ hay bỏ node hiện tại
    }
}