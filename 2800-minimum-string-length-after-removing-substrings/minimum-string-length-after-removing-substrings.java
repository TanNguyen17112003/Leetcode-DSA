class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
           if (c == 'B' && !stack.empty() && stack.peek() == 'A') stack.pop();
           else if (c == 'D' && !stack.empty() && stack.peek() == 'C') stack.pop();
           else stack.push(c);
        }

        int count = 0;
        while (!stack.isEmpty()) {
            count++;
            stack.pop();
        } 
        return count;
    }
}