class Solution {
    public boolean rotateString(String s, String goal) {
        int sLen = s.length();
        int goalLen = goal.length();
        if (sLen != goalLen) return false;
        
        for (int gap=0; gap<sLen; gap++) {
            boolean match = true;
            for (int i=0; i<sLen; i++) {
                if (s.charAt(i) != goal.charAt((i + gap) % sLen)) {
                    match = false;
                    break;
                }
            }
            if (match == true) return true;
        }

        return false;
    }
}