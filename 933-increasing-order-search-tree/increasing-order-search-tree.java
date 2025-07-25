class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0); // node giả để dễ nối
        TreeNode current = dummy;
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            // 1. Duyệt hết bên trái
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // 2. Lấy node từ stack
            node = stack.pop();

            // 3. Xử lý node
            node.left = null;                // bỏ liên kết trái
            current.right = node;           // nối vào cây mới
            current = current.right;        // di chuyển tới node vừa thêm

            // 4. Tiếp tục duyệt cây con phải
            node = node.right;
        }

        return dummy.right; // bỏ node giả, trả về cây kết quả
    }
}
