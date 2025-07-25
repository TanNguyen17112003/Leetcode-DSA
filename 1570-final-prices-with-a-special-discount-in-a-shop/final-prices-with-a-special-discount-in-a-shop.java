import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack chứa giá trị

        for (int i = n - 1; i >= 0; i--) {
            // Loại bỏ các giá trị lớn hơn prices[i]
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // Nếu stack không rỗng, phần tử đầu tiên nhỏ hơn hoặc bằng là giảm giá
            result[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();

            // Push chính phần tử hiện tại để dùng cho phần tử bên trái
            stack.push(prices[i]);
        }

        return result;
    }
}
