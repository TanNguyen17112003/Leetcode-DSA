class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                  stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        StringBuilder s1 = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            s1.insert(0, c);
        }

        return s1.toString();
    }
}