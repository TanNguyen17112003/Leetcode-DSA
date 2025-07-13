class Solution {
    public boolean isPalindromeString(String x) {
        int len = x.length();
        if (len == 0 || len == 1) return true;
        for (int i = 0; i < len/2; i++) {
            if (x.charAt(i) != x.charAt(len-i-1)) return false;
        }
        return true;
    }
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        return isPalindromeString(str);
    }
}