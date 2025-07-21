class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
                continue;
            }

            char updatedLeft = Character.toLowerCase(s.charAt(left));
            char updatedRight = Character.toLowerCase(s.charAt(right));

            if (updatedLeft != updatedRight) return false;
            left++;
            right--;
        }
        return true;
    }
}