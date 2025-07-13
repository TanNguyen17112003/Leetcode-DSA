class Solution {

    public boolean isPalindromeString(String s) {
        int length = s.length();
        if (length == 0 || length == 1)
            return true;
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i))
                return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int max = 1;
        String result = String.valueOf(s.charAt(0));
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j <= len - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String subString = s.substring(i, j + 1);
                    if (isPalindromeString(subString)) {
                        int subLen = subString.length();
                        if (subLen > max) {
                            max = subLen;
                            result = subString;
                        }
                    }
                }
            }
        }
        return result;
    }
}