class Solution {
    public char kthCharacter(int k) {
        String result = "a";
        int numberOfAddition = 0;
        while (Math.pow(2, numberOfAddition) < k) {
            numberOfAddition++;
        }
        for (int i = 0; i < numberOfAddition; i++) {
            StringBuilder newString = new StringBuilder();
            for (int j = 0; j < result.length(); j++) {
                char nc = nextChar(result.charAt(j));
                newString.append(nc);
            }
            result += newString.toString();
        }
        return result.charAt(k-1);
    }

    private char nextChar(char c) {
    if (c >= 'a' && c <= 'z') {
        return (c == 'z') ? 'a' : (char)(c + 1);
    }
    if (c >= 'A' && c <= 'Z') {
        return (c == 'Z') ? 'A' : (char)(c + 1);
    }
    throw new IllegalArgumentException("Input must be a letter (a-z or A-Z)");
}
}