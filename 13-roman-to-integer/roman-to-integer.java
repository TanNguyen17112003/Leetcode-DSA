class Solution {
    public int convertBasicCharacter(char c) {
        int[] intList = {1000, 500, 100, 50, 10, 5, 1};
        char[] stringList = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] == c) {
                return intList[i];
            }
        } 
        return -1;
    }
    public int romanToInt(String s) {
       
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return convertBasicCharacter(s.charAt(0));
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (i < len-1) {
                char first = s.charAt(i);
                char second = s.charAt(i+1);
                int firstValue = convertBasicCharacter(first);
                int secondValue = convertBasicCharacter(second);
                result = firstValue < secondValue ? result - firstValue : result + firstValue;
            }
            if (i == len-1) {
                result += convertBasicCharacter(s.charAt(i));
            }
            
        }
        return result;
    }
}