class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] arrays = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arrays[i] = new StringBuilder();
        }
        int maxSpace = 2*numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int firstSpace = maxSpace - 2*(i%numRows);
            int secondSpace = maxSpace - firstSpace;
            int j = i;
            boolean isFirstSpace = true;
            while (j < len) {
                arrays[i].append(s.charAt(j));
                if (isFirstSpace && firstSpace != 0) {
                    j += firstSpace;
                } else if (!isFirstSpace && secondSpace != 0) {
                    j += secondSpace;
                } else {
                    j += firstSpace + secondSpace; // đảm bảo không bị đứng mãi
                }
                isFirstSpace = !isFirstSpace;
            }

        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(arrays[i]);
        }
        return result.toString();
    }   
}