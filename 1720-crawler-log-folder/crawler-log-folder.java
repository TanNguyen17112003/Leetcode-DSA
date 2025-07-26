class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        int current = 0;
    
        for (String log: logs) {
            if (log.equals("../")) {
                if (current == 0) continue;
                else {
                    current--;
                }
            }
            else if (log.equals("./")) continue;
            else current++;
        }

        return current;
    }
}