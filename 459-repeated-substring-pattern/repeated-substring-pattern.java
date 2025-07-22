class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len <= 1) return false;

        for (int subLen = 1; subLen <= len / 2; subLen++) {
            if (len % subLen != 0) continue;

            StringBuffer pattern = new StringBuffer();
            for (int i = 0; i < subLen; i++) {
                pattern.append(s.charAt(i));
            }

            boolean match = true;
            for (int i = subLen; i < len; i++) {
                if (s.charAt(i) != pattern.charAt(i % subLen)) {
                    match = false;
                    break;
                }
            }

            if (match) return true;
        }

        return false;
    }
}
