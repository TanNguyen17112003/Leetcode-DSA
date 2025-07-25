class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int len = operations.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (operations[i].equals("D")) {
                int value = stack.peek();
                stack.push(2 * value);
            }

            else if (operations[i].equals("C")) {
                stack.pop();
            }

            else if (operations[i].equals("+")) {
                Stack<Integer> stack2 = new Stack<>();
                int total = 0;
                for (int j = 0; j < 2; j++) {
                    int peekValue = stack.pop();
                    stack2.push(peekValue);
                    total += peekValue;
                }
                for (int j = 0; j < 2; j++) {
                    stack.push(stack2.pop());
                }
                stack.push(total);
            }

            else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}