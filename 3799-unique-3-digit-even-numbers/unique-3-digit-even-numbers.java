class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i == j || j == k || k == i) continue;
                    
                    int d1 = digits[i], d2 = digits[j], d3 = digits[k];
                    if (d1 == 0) continue;
                    if (d3 % 2 != 0) continue;

                    int number = d1 * 100 + d2 * 10 + d3;
                    result.add(number);
                }
            }
        }
        return result.size();
    }
}