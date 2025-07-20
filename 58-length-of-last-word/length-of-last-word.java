class Solution {
    public int lengthOfLastWord(String s) {
        String result = s.trim();
        int len = 0;
        if (result.length() == 0) return 0;
        if (result.length() == 1) return 1;
        int index = result.length() - 1;
        while (index >= 0 && result.charAt(index) != ' ') {
            len++;
            index--;
        }
        return len;
    }
}