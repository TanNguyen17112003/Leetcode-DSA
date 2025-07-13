class Solution {
    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String s) {
        // Create util variables
        int len = s.length();
        int UP_SIDE = (int) Math.pow(2, 31);
        int DOWN_SIDE = (int) -Math.pow(2, 31);

        // Create a new SrinBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == 0 && s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
                continue;
            }
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                break;
            }
            if (s.charAt(i) != ' ')
                sb.append(s.charAt(i));
        }

        // CheckNegative
        boolean isNegative = sb.length() > 1 && sb.charAt(0) == '-' && isNumber(sb.charAt(1));
        while (sb.length() > 1 && ((sb.charAt(0) == '0' && (sb.charAt(1) != '-' && sb.charAt(1) != '+'))
                || ((sb.charAt(0) == '-' || sb.charAt(0) == '+') && (sb.charAt(1) != '-' && sb.charAt(1) != '+'))))
            sb.deleteCharAt(0);
        StringBuilder newSb = new StringBuilder();
        while (sb.length() > 0 && isNumber(sb.charAt(0))) {
            char firstNumber = sb.charAt(0);
            newSb.append(firstNumber);
            sb.deleteCharAt(0);
        }
        long parsed = 0;
        for (int i = 0; i < newSb.length(); i++) {
            int digit = newSb.charAt(i) - '0';

            // Check overflow before it happens
            if (parsed > (Long.MAX_VALUE - digit) / 10) {
                parsed = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                return (int) parsed;
            }

            parsed = parsed * 10 + digit;
        }

        parsed = isNegative ? -parsed : parsed;

        // Clamp to int range
        if (parsed > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (parsed < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) parsed;
    }
}