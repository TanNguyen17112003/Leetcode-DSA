class Solution {
    public int minimumPairRemoval(int[] nums) {
        if (nums.length <= 1) return 0;

        // 1. Build doubly linked list
        Node head = new Node(nums[0]), prev = head;
        for (int i = 1; i < nums.length; i++) {
            Node cur = new Node(nums[i]);
            prev.next = cur;
            cur.prev = prev;
            prev = cur;
        }

        int steps = 0;

        while (!isSorted(head)) {
            // 2. Find min pair
            Node minNode = null;
            int minSum = Integer.MAX_VALUE;
            for (Node cur = head; cur != null && cur.next != null; cur = cur.next) {
                int sum = cur.val + cur.next.val;
                if (sum < minSum) {
                    minSum = sum;
                    minNode = cur;
                }
            }

            // 3. Remove cur and cur.next, insert new node with sum
            Node first = minNode;
            Node second = minNode.next;
            Node newNode = new Node(first.val + second.val);

            Node prevNode = first.prev;
            Node nextNode = second.next;

            if (prevNode != null) {
                prevNode.next = newNode;
                newNode.prev = prevNode;
            } else {
                head = newNode;
            }

            if (nextNode != null) {
                newNode.next = nextNode;
                nextNode.prev = newNode;
            }

            steps++;
        }

        return steps;
    }

    private boolean isSorted(Node head) {
        while (head != null && head.next != null) {
            if (head.val > head.next.val) return false;
            head = head.next;
        }
        return true;
    }

    private static class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }
}
