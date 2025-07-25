class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        int sLen = s.length(), tLen = t.length();
        int sIndex = 0, tIndex = 0;

        while (sIndex < sLen) {
            if (s.charAt(sIndex) == '#') {
                if (stackS.isEmpty()) {
                    sIndex++;
                    continue;
                }
                else {
                    stackS.pop();
                }
            }
            else stackS.push(s.charAt(sIndex));
            sIndex++;
        }

        while (tIndex < tLen) {
            if (t.charAt(tIndex) == '#') {
                if (stackT.isEmpty()) {
                    tIndex++;
                    continue;
                }
                else {
                    stackT.pop();
                }
            }
            else stackT.push(t.charAt(tIndex));
            tIndex++;
        } 

        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            char sLetter = stackS.pop();
            char tLetter = stackT.pop();
            if (sLetter != tLetter) return false;
        }

        return stackS.isEmpty() && stackT.isEmpty();
    }
}