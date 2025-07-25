class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuffer s = new StringBuffer();
        int firstIndex = word.indexOf(ch);
        if (firstIndex == -1) return word;
        for (int i = firstIndex; i >= 0; i--) {
            s.append(word.charAt(i));
        }

        for (int i = firstIndex+1; i < word.length(); i++) {
            s.append(word.charAt(i));
        }

        return s.toString();
    }
}